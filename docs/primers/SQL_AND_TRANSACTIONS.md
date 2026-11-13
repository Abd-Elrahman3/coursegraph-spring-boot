# SQL and Transactions

Start with PK/FK/UNIQUE/CHECK/NOT NULL and a schema migration. Show an invalid direct SQL insert rejected by the database. Read an EXPLAIN ANALYZE plan with buffers; an index has write/storage cost and may be ignored for a tiny table.

READ COMMITTED does not make check-then-insert safe. Use a constraint plus locking or a correctly retried serializable transaction. Lock related rows in a consistent order. Never hold a transaction open while waiting on an unreliable network provider. Test rollback and deadlock/serialization retry limits.

Outbox makes local state and the intent to publish atomic; it does not make the broker and database one transaction. Consumers deduplicate inside the transaction containing their effects. Caches and projections are derived state; document allowable staleness.

Read https://www.postgresql.org/docs/16/transaction-iso.html and https://www.postgresql.org/docs/16/using-explain.html.
