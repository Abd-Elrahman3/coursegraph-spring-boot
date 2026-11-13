#!/usr/bin/env python3
"""Cumulative learning checks. These are self-study guardrails, not a hidden grader."""
import argparse, os, re, subprocess, sys
import xml.etree.ElementTree as ET
from pathlib import Path

ORDER = ['M1','M2','M3','D4','D5','D6','D7']
root = Path(__file__).resolve().parents[1]
parser = argparse.ArgumentParser()
parser.add_argument('--through', required=True, choices=ORDER)
args = parser.parse_args()
selected = ORDER[:ORDER.index(args.through)+1]
problems = []
for milestone in selected:
    evidence = root/'docs'/'evidence'/(milestone+'.md')
    value = evidence.read_text() if evidence.exists() else ''
    if 'Status: complete' not in value or re.search(r'\bTODO\b', value):
        problems.append(f'{milestone}: fill evidence and set Status: complete')
    if len(value.strip()) < 400:
        problems.append(f'{milestone}: evidence must contain reproduction, actual result and explanation')
    number = ORDER.index(milestone)+1
    for suffix in ['01','02']:
        if f'BR-{number}{suffix}' not in value:
            problems.append(f'{milestone}: evidence must map BR-{number}{suffix} to a test')
    filename = 'M1DomainTest.java' if milestone=='M1' else milestone+'AcceptanceTest.java'
    files = list((root/'src/test/java').rglob(filename))
    if len(files)!=1:
        problems.append(f'{milestone}: required {filename} missing or duplicated')
        continue
    source=files[0].read_text()
    if '@Disabled' in source or '@Ignore' in source or 'TODO:' in source:
        problems.append(f'{milestone}: replace pending tests with real assertions; do not disable tests')
if args.through=='D7':
    for path in (root/'src/main').rglob('*'):
        if path.is_file() and path.suffix in {'.java','.sql','.yml','.yaml'}:
            if 'TODO:' in path.read_text(): problems.append(f'Unfinished production exercise: {path.relative_to(root)}')
    if 'TODO:' in (root/'REFLECTION.md').read_text(): problems.append('Complete REFLECTION.md')
if problems:
    print('Learning gate needs work:\n- '+'\n- '.join(problems)); sys.exit(1)
wrapper = 'mvnw.cmd' if os.name=='nt' else './mvnw'
command=[wrapper,'-B','-ntp','-Plearning','-Dmilestone.groups=structure,'+','.join(selected),'clean','verify']
print('Running:', ' '.join(command), flush=True)
result=subprocess.run(command,cwd=root)
if result.returncode: sys.exit(result.returncode)
suites=[]
for report in (root/'target/surefire-reports').glob('TEST-*.xml'):
    suite=ET.parse(report).getroot()
    suites.append(suite)
    if any(int(suite.get(k,'0')) for k in ['failures','errors','skipped']):
        problems.append(f'Nonpassing or skipped tests: {suite.get("name")}')
for milestone in selected:
    expected='M1DomainTest' if milestone=='M1' else milestone+'AcceptanceTest'
    matches=[s for s in suites if s.get('name','').endswith('.'+expected)]
    if len(matches)!=1 or int(matches[0].get('tests','0'))<2:
        problems.append(f'{milestone}: required suite must execute at least two real tests')
if problems:
    print('Learning gate failed:\n- '+'\n- '.join(problems)); sys.exit(1)
print('Cumulative gate passed through '+args.through+'. Review evidence and test quality before advancing.')
