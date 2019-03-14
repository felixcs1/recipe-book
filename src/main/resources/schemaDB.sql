DROP TABLE IF EXISTS recipe_tools;
DROP TABLE IF EXISTS recipe_foods;
DROP TABLE IF EXISTS instructions;
DROP TABLE IF EXISTS tools;
DROP TABLE IF EXISTS foods;
DROP TABLE IF EXISTS recipes;

CREATE TABLE IF NOT EXISTS recipes (
	recipe_id serial PRIMARY KEY,
	recipe_name VARCHAR (50) NOT NULL,
	description VARCHAR (255),
	serves INT,
	UNIQUE (recipe_name)
);

CREATE TABLE IF NOT EXISTS instructions (
	instruction_id serial PRIMARY KEY,
	instruction VARCHAR (255),
	recipe_id INTEGER REFERENCES recipes(recipe_id) ON DELETE CASCADE,
	step INT,
	UNIQUE (recipe_id, step)
);

CREATE TABLE IF NOT EXISTS foods (
	food_id serial PRIMARY KEY,
	food_name VARCHAR (255),
	units VARCHAR (255),
	isLiquid boolean NOT NUll,
	UNIQUE (food_name)
);

CREATE TABLE IF NOT EXISTS tools (
	tool_id serial PRIMARY KEY,
	tool_name VARCHAR (255),
	UNIQUE (tool_name)
);

CREATE TABLE IF NOT EXISTS recipe_tools (
  recipe_id INTEGER REFERENCES recipes(recipe_id) ON DELETE CASCADE,
  tool_id INTEGER REFERENCES tools(tool_id) ON DELETE CASCADE,
  UNIQUE (recipe_id, tool_id)
);

CREATE TABLE IF NOT EXISTS recipe_foods (
  recipe_id INTEGER REFERENCES recipes(recipe_id) ON DELETE CASCADE,
  food_id INTEGER REFERENCES foods(food_id) ON DELETE CASCADE,
  quantity INT,
  UNIQUE (recipe_id, food_id)
);