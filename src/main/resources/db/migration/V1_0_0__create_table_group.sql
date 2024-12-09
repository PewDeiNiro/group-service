CREATE SCHEMA IF NOT EXISTS groups;

CREATE TABLE IF NOT EXISTS groups.groups(
    id SERIAL PRIMARY KEY,
    title VARCHAR,
    description VARCHAR,
    type VARCHAR,
    wall_id INTEGER REFERENCES posts.walls(id)
);

CREATE TABLE IF NOT EXISTS groups.subscribers(
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users.users(id),
    group_id INTEGER REFERENCES groups.groups(id)
);

CREATE TABLE IF NOT EXISTS groups.banlist(
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users.users(id),
    group_id INTEGER REFERENCES groups.groups(id)
);