# Submission Rules

## 1. Workflow

For each milestone start from updated `main`, create its branch, commit small changes, push and open a GitHub pull request into `main`. Explain the rule, evidence and failures tested. Merge after cumulative learning checks pass. No deadline is imposed; progression depends on demonstrated behavior.

| Milestone | Branch |
| --- | --- |
| M1 | feature/m1-domain |
| M2 | feature/m2-database |
| M3 | feature/m3-transactions |
| D4 | feature/d4-api |
| D5 | feature/d5-advanced |
| D6 | feature/d6-failures |
| D7 | feature/d7-operations |

## 2. Commits and review

Use messages such as `M3: reject duplicate active reservation`. Fill the PR template when provided. Include migration impact and rollback/recovery notes. Commit with your own configured Git identity. Do not commit secrets, database dumps with real data, build outputs or IDE files.

## 3. What may change

Implement TODOs, add production/test classes and dependencies when justified, and extend schema/contracts compatibly. Keep rule semantics and provided behavioral assertions. Do not disable tests or remove gates to claim a level. This is a self-study repository; these instructions do not install remote branch protection or a hidden bot.

## 4. Completion

Every rule requires a meaningful passing test, evidence command/output and an explanation of the underlying concept. D7 requires the failure drills, load/restore measurements and REFLECTION.md. `python3 scripts/check_progress.py --through D7` checks the repository-side guardrails.

## 5. Understanding

You may consult documentation and ask for hints. Do not replace the exercise with an unexplained generated implementation. Be able to change a rule and update its tests live. If stuck, reduce the problem to an isolated SQL transaction, HTTP fixture or unit test, then return to the milestone.
