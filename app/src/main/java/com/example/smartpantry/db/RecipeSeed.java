package com.example.smartpantry.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.smartpantry.logic.IngredientNormalizer;

/**
 * Seeds 18 starter recipes into the database on first run.
 * This is a unique South-African inspired menu so the app feels local.
 * Quantities are kept small and in simple units (pcs / g / ml) so the
 * strict-matching rule is easy to demonstrate in the video.
 */
final class RecipeSeed {

    private RecipeSeed() { }

    static void seed(SQLiteDatabase db) {
        // --- 1 ---
        long id = recipe(db, "Savoury Mince Pap",
                "1. Cook the maize meal in salted water into a firm pap.\n" +
                "2. Brown the mince with the chopped onion.\n" +
                "3. Stir in the tomatoes and simmer until thick.\n" +
                "4. Spoon the mince over the pap and serve.");
        ing(db, id, "Maize Meal", 250, "g");
        ing(db, id, "Beef Mince", 300, "g");
        ing(db, id, "Onion", 1, "pcs");
        ing(db, id, "Tomatoes", 2, "pcs");
        ing(db, id, "Salt", 3, "g");
        ing(db, id, "Oil", 15, "ml");

        // --- 2 ---
        id = recipe(db, "Chakalaka Beans",
                "1. Fry the onion, carrot and pepper in oil.\n" +
                "2. Stir in the curry powder for one minute.\n" +
                "3. Add the baked beans and warm through.\n" +
                "4. Serve hot as a relish.");
        ing(db, id, "Baked Beans", 400, "g");
        ing(db, id, "Carrot", 1, "pcs");
        ing(db, id, "Onion", 1, "pcs");
        ing(db, id, "Bell Pepper", 1, "pcs");
        ing(db, id, "Curry Powder", 5, "g");
        ing(db, id, "Oil", 15, "ml");

        // --- 3 ---
        id = recipe(db, "Bunny Chow",
                "1. Brown the mince with onion and curry powder.\n" +
                "2. Add diced potato and a little water, simmer soft.\n" +
                "3. Hollow out the bread and fill with the curry.");
        ing(db, id, "Bread", 1, "pcs");
        ing(db, id, "Beef Mince", 300, "g");
        ing(db, id, "Onion", 1, "pcs");
        ing(db, id, "Potatoes", 2, "pcs");
        ing(db, id, "Curry Powder", 8, "g");
        ing(db, id, "Salt", 3, "g");

        seedPart2(db);
        seedPart3(db);
    }

    private static void seedPart2(SQLiteDatabase db) {
        // --- 4 ---
        long id = recipe(db, "Boerewors Roll",
                "1. Grill the boerewors until cooked through.\n" +
                "2. Fry the sliced onion and tomato until soft.\n" +
                "3. Place the wors in the bread and top with the onion.");
        ing(db, id, "Boerewors", 1, "pcs");
        ing(db, id, "Bread", 1, "pcs");
        ing(db, id, "Onion", 1, "pcs");
        ing(db, id, "Tomatoes", 1, "pcs");
        ing(db, id, "Oil", 10, "ml");

        // --- 5 ---
        id = recipe(db, "Peri-Peri Chicken",
                "1. Mix garlic, lemon juice, chilli and oil into a marinade.\n" +
                "2. Coat the chicken and rest it briefly.\n" +
                "3. Grill until cooked and season with salt.");
        ing(db, id, "Chicken Breast", 250, "g");
        ing(db, id, "Garlic", 3, "pcs");
        ing(db, id, "Lemon", 1, "pcs");
        ing(db, id, "Chilli Flakes", 3, "g");
        ing(db, id, "Oil", 20, "ml");
        ing(db, id, "Salt", 2, "g");

        // --- 6 ---
        id = recipe(db, "Vetkoek",
                "1. Mix flour, yeast, sugar and salt with warm water.\n" +
                "2. Let the dough rise, then shape into balls.\n" +
                "3. Deep-fry in oil until golden.");
        ing(db, id, "Flour", 300, "g");
        ing(db, id, "Yeast", 7, "g");
        ing(db, id, "Sugar", 15, "g");
        ing(db, id, "Salt", 3, "g");
        ing(db, id, "Oil", 200, "ml");

        // --- 7 ---
        id = recipe(db, "Milk Tart",
                "1. Heat the milk and stir in flour and sugar.\n" +
                "2. Whisk in the eggs and cook until thick.\n" +
                "3. Pour into a crust and dust with cinnamon.");
        ing(db, id, "Milk", 500, "ml");
        ing(db, id, "Flour", 60, "g");
        ing(db, id, "Eggs", 2, "pcs");
        ing(db, id, "Sugar", 80, "g");
        ing(db, id, "Cinnamon", 2, "g");

        // --- 8 ---
        id = recipe(db, "Malva Pudding",
                "1. Beat sugar, eggs and apricot jam together.\n" +
                "2. Fold in flour, melted butter and milk.\n" +
                "3. Bake until risen and golden.");
        ing(db, id, "Flour", 200, "g");
        ing(db, id, "Sugar", 150, "g");
        ing(db, id, "Eggs", 2, "pcs");
        ing(db, id, "Apricot Jam", 45, "g");
        ing(db, id, "Milk", 125, "ml");
        ing(db, id, "Butter", 30, "g");

        // --- 9 ---
        id = recipe(db, "Potjie Veg Stew",
                "1. Fry the onion in oil at the bottom of the pot.\n" +
                "2. Layer potato, carrot and peas on top.\n" +
                "3. Add a crumbled stock cube and water, simmer slowly.");
        ing(db, id, "Potatoes", 3, "pcs");
        ing(db, id, "Carrot", 2, "pcs");
        ing(db, id, "Onion", 1, "pcs");
        ing(db, id, "Peas", 80, "g");
        ing(db, id, "Stock Cube", 1, "pcs");
        ing(db, id, "Oil", 15, "ml");

        // --- 10 ---
        id = recipe(db, "Samp & Beans",
                "1. Soak the samp and sugar beans, then boil until soft.\n" +
                "2. Fry the onion and stir it through.\n" +
                "3. Season with salt and serve warm.");
        ing(db, id, "Samp", 250, "g");
        ing(db, id, "Sugar Beans", 150, "g");
        ing(db, id, "Onion", 1, "pcs");
        ing(db, id, "Salt", 4, "g");
        ing(db, id, "Oil", 15, "ml");

        // --- 11 ---
        id = recipe(db, "Braai Mealies",
                "1. Peel back the husks from the corn.\n" +
                "2. Grill over coals, turning often.\n" +
                "3. Rub with butter and sprinkle with salt.");
        ing(db, id, "Corn", 2, "pcs");
        ing(db, id, "Butter", 30, "g");
        ing(db, id, "Salt", 2, "g");
    }

    private static void seedPart3(SQLiteDatabase db) {
        // --- 12 ---
        long id = recipe(db, "Tomato Bredie",
                "1. Brown the lamb with the onion.\n" +
                "2. Add tomatoes and potato, cover with water.\n" +
                "3. Simmer slowly until tender and season with salt.");
        ing(db, id, "Lamb", 400, "g");
        ing(db, id, "Tomatoes", 3, "pcs");
        ing(db, id, "Onion", 1, "pcs");
        ing(db, id, "Potatoes", 2, "pcs");
        ing(db, id, "Salt", 3, "g");
        ing(db, id, "Oil", 15, "ml");

        // --- 13 ---
        id = recipe(db, "Avocado Toast",
                "1. Toast the bread.\n" +
                "2. Mash the avocado with lemon juice and salt.\n" +
                "3. Spread on the toast and top with chilli flakes.");
        ing(db, id, "Bread", 2, "pcs");
        ing(db, id, "Avocados", 1, "pcs");
        ing(db, id, "Lemon", 1, "pcs");
        ing(db, id, "Salt", 1, "g");
        ing(db, id, "Chilli Flakes", 2, "g");

        // --- 14 ---
        id = recipe(db, "Rooibos Iced Tea",
                "1. Brew the rooibos tea in hot water.\n" +
                "2. Stir in sugar until dissolved.\n" +
                "3. Chill and serve with a slice of lemon.");
        ing(db, id, "Rooibos Tea", 2, "pcs");
        ing(db, id, "Sugar", 20, "g");
        ing(db, id, "Lemon", 1, "pcs");
        ing(db, id, "Water", 500, "ml");

        // --- 15 ---
        id = recipe(db, "Pumpkin Fritters",
                "1. Mash cooked pumpkin and mix with flour and egg.\n" +
                "2. Add a little sugar and cinnamon.\n" +
                "3. Fry spoonfuls in oil until golden.");
        ing(db, id, "Pumpkin", 300, "g");
        ing(db, id, "Flour", 100, "g");
        ing(db, id, "Eggs", 1, "pcs");
        ing(db, id, "Sugar", 20, "g");
        ing(db, id, "Cinnamon", 2, "g");
        ing(db, id, "Oil", 30, "ml");

        // --- 16 ---
        id = recipe(db, "Cheese Griller Wrap",
                "1. Fry the sausage and sliced onion.\n" +
                "2. Warm the tortilla in the pan.\n" +
                "3. Fill with cheese, sausage, onion and tomato, then roll.");
        ing(db, id, "Tortilla", 1, "pcs");
        ing(db, id, "Cheese", 60, "g");
        ing(db, id, "Sausage", 1, "pcs");
        ing(db, id, "Tomatoes", 1, "pcs");
        ing(db, id, "Onion", 1, "pcs");

        // --- 17 ---
        id = recipe(db, "Banana Bread",
                "1. Mash the bananas and beat in egg, sugar and butter.\n" +
                "2. Fold in the flour.\n" +
                "3. Bake in a loaf tin until a skewer comes out clean.");
        ing(db, id, "Flour", 250, "g");
        ing(db, id, "Bananas", 3, "pcs");
        ing(db, id, "Eggs", 2, "pcs");
        ing(db, id, "Sugar", 120, "g");
        ing(db, id, "Butter", 80, "g");

        // --- 18 ---
        id = recipe(db, "Yogurt Granola Bowl",
                "1. Spoon the yogurt into a bowl.\n" +
                "2. Add the granola and sliced banana.\n" +
                "3. Drizzle with honey and serve.");
        ing(db, id, "Yogurt", 200, "g");
        ing(db, id, "Granola", 60, "g");
        ing(db, id, "Bananas", 1, "pcs");
        ing(db, id, "Honey", 20, "ml");
    }

    // ------------------------------------------------------------------
    // small helpers
    // ------------------------------------------------------------------

    static long recipe(SQLiteDatabase db, String name, String steps) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.R_NAME, name);
        cv.put(DatabaseHelper.R_STEPS, steps);
        return db.insert(DatabaseHelper.T_RECIPES, null, cv);
    }

    static void ing(SQLiteDatabase db, long recipeId, String name, double qty, String unit) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.RI_RECIPE, recipeId);
        cv.put(DatabaseHelper.RI_NAME, name);
        cv.put(DatabaseHelper.RI_QTY, qty);
        cv.put(DatabaseHelper.RI_UNIT, IngredientNormalizer.unit(unit));
        db.insert(DatabaseHelper.T_RING, null, cv);
    }
}
