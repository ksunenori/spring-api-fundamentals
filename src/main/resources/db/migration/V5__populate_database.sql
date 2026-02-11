-- Categories
INSERT INTO categories (name)
VALUES ('Fruits & Vegetables');
INSERT INTO categories (name)
VALUES ('Dairy & Eggs');
INSERT INTO categories (name)
VALUES ('Meat & Seafood');
INSERT INTO categories (name)
VALUES ('Bakery');
INSERT INTO categories (name)
VALUES ('Beverages');

-- Fruits & Vegetables (category_id = 1)
INSERT INTO products (name, price, description, category_id)
VALUES ('Organic Bananas', 0.79,
        'Bundle of organic bananas, approximately 2 lbs. Sourced from Ecuador. Rich in potassium and naturally sweet.',
        1);

INSERT INTO products (name, price, description, category_id)
VALUES ('Hass Avocados', 1.49,
        'Single ripe Hass avocado from Mexico. Creamy texture, perfect for guacamole, toast, or salads.', 1);

-- Dairy & Eggs (category_id = 2)
INSERT INTO products (name, price, description, category_id)
VALUES ('Horizon Organic Whole Milk', 5.99,
        'Half gallon of Horizon organic whole milk. Pasture-raised, USDA certified organic. No antibiotics or added hormones.',
        2);

INSERT INTO products (name, price, description, category_id)
VALUES ('Vital Farms Pasture-Raised Eggs', 6.49,
        'Dozen large pasture-raised eggs from Vital Farms. Hens raised on family farms with 108 sq ft of outdoor space per bird.',
        2);

-- Meat & Seafood (category_id = 3)
INSERT INTO products (name, price, description, category_id)
VALUES ('Boneless Skinless Chicken Breast', 8.99,
        'Per pound price. Fresh boneless skinless chicken breast. USDA inspected, no added hormones or steroids.', 3);

INSERT INTO products (name, price, description, category_id)
VALUES ('Atlantic Salmon Fillet', 12.99,
        'Per pound price. Fresh Atlantic salmon fillet. Rich in omega-3 fatty acids. Farm-raised, skin-on.', 3);

-- Bakery (category_id = 4)
INSERT INTO products (name, price, description, category_id)
VALUES ('Dave''s Killer Bread 21 Whole Grains', 5.49,
        '27 oz loaf of Dave''s Killer Bread. Packed with 21 whole grains and seeds. USDA organic, non-GMO, 5g protein per slice.',
        4);

INSERT INTO products (name, price, description, category_id)
VALUES ('Thomas'' Original English Muffins', 4.29,
        'Pack of 6 Thomas'' English Muffins. Nooks and crannies for perfect butter and jam absorption. A breakfast staple since 1880.',
        4);

-- Beverages (category_id = 5)
INSERT INTO products (name, price, description, category_id)
VALUES ('Liquid Death Mountain Water', 1.89,
        'Single 19.2 oz tallboy can of Liquid Death still mountain water. Sourced from the Austrian Alps. Infinitely recyclable aluminum.',
        5);

INSERT INTO products (name, price, description, category_id)
VALUES ('Celsius Sparkling Orange', 2.49,
        'Single 12 oz can of Celsius sparkling orange fitness drink. 200mg caffeine, 7 essential vitamins, zero sugar, no artificial flavors.',
        5);