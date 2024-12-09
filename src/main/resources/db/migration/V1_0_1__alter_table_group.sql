ALTER TABLE groups.groups ADD COLUMN creator_id INTEGER REFERENCES users.users(id);

CREATE TABLE IF NOT EXISTS groups.group_admins(
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users.users(id),
    group_id INTEGER REFERENCES groups.groups(id)
);