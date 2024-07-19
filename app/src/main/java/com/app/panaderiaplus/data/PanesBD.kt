package com.app.panaderiaplus.data

import com.app.panaderiaplus.R

interface FuentePanes {
    fun getPanesRegistrados(): List<Pan>
}

class PanesBD : FuentePanes {

override fun getPanesRegistrados(): List<Pan> {
        return mutableListOf(
            Pan(
                id = 10L,
                name = "Brownie de nueces",
                imageUrl = R.drawable.brownie_transparent,
                description = "Brownies horneados con nueces , altos en proteina",
                ingredients = "Chocolate negro 90% puro, cacao en polvo, huevos de granja, mantequilla fresca (no margarina), sal de mar, harina de centeno y proteina de leche",
                orderDescription = "150 kcal",
                price = 1.5,
                isFavourite = true,
                category = "postres"
            ),
            Pan(
                id = 1L,
                name = "Pan de Manteca",
                imageUrl = R.drawable.pan_manteca,
                description = "Pan suave y esponjoso, perfecto para el desayuno ",
                ingredients = "Harina de trigo, mantequilla, leche, azúcar, sal, levadura",
                orderDescription = "120 kcal",
                price = 0.5,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 2L,
                name = "Pan dulce",
                imageUrl = R.drawable.pan_sweet,
                description = "Pan ligeramente dulce con una corteza crujiente.",
                ingredients = "Harina de trigo, azúcar, mantequilla, huevos, leche, levadura, sal",
                orderDescription = "150 kcal",
                price = 0.6,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 3L,
                name = "Pan de queso",
                imageUrl = R.drawable.pan_cheese,
                description = "Pan relleno de queso, ideal para acompañar el café.",
                ingredients = "Harina de trigo, queso, mantequilla, leche, azúcar, sal, levadura. ",
                orderDescription = "200 kcal",
                price = 1.0,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 4L,
                name = "Pastel de chocolate",
                imageUrl = R.drawable.chocolate_cake,
                description = "Pastel esponjoso de chocolate, cubierto con glaseado de chocolate.",
                ingredients = "Harina de trigo, azúcar, cacao en polvo, mantequilla, huevos, leche, polvo de hornear, vainilla. ",
                orderDescription = "350 kcal",
                price = 12.5,
                isFavourite = false,
                category = "postres"
            ),
            Pan(
                id = 5L,
                name = "Torta de Zanahoria",
                imageUrl = R.drawable.carrot_cake,
                description = "Torta húmeda de zanahoria con un toque de canela y nueces",
                ingredients = "Harina de trigo, zanahorias ralladas, azúcar, aceite, huevos, nueces, canela, bicarbonato de sodio. ",
                orderDescription = "300 kcal",
                price = 15.0,
                isFavourite = false,
                category = "postres"
            ),
            Pan(
                id = 6L,
                name = "Empanada de carne",
                imageUrl = R.drawable.empanada_de_carne,
                description = ": Empanada rellena de carne sazonada y vegetales",
                ingredients = "Harina de trigo, carne molida, cebolla, pimiento, aceite, comino, sal, levadura",
                orderDescription = "200 kcal",
                price = 1.5,
                isFavourite = false,
                category = "otro"
            ),
            Pan(
                id = 7L,
                name = "Croissant",
                imageUrl = R.drawable.croissant,
                description = "Bollería francesa, crujiente por fuera y suave por dentro",
                ingredients = "Harina de trigo, mantequilla, leche, azúcar, sal, levadura.",
                orderDescription = "120 kcal",
                price = 0.60,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 8L,
                name = "Muffin de Arandanos",
                imageUrl = R.drawable.muffin_blueberry,
                description = "Muffin esponjoso con arándanos frescos",
                ingredients = "Harina de trigo, azúcar, arándanos, mantequilla, huevos, leche, polvo de hornear, sal. ",
                orderDescription = "220 kcal",
                price = 1.8,
                isFavourite = false,
                category = "postre"
            ),
            Pan(
                id = 9L,
                name = "Galletas de avena",
                imageUrl = R.drawable.galletas_de_avena,
                description = "Galletas crujientes con un toque de canela y pasas",
                ingredients = "Avena, harina de trigo, azúcar, mantequilla, huevos, canela, pasas, bicarbonato de sodio",
                orderDescription = "300 ml",
                price = 0.5,
                isFavourite = false,
                category = "otro"
            ),
            Pan(
                id = 29L,
                name = "Café Expreso",
                imageUrl = R.drawable.brownie_transparent,
                description = "Café expreso fuerte y concentrado, perfecto para comenzar el día.",
                ingredients = "Café",
                orderDescription = "1 taza",
                price = 2.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 30L,
                name = "Café Americano",
                imageUrl = R.drawable.brownie_transparent,
                description = "Café americano suave, preparado con agua caliente y un shot de expreso.",
                ingredients = "Café, agua",
                orderDescription = "1 taza",
                price = 2.5,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 31L,
                name = "Cappuccino",
                imageUrl = R.drawable.brownie_transparent,
                description = "Café cappuccino cremoso con una capa de espuma de leche.",
                ingredients = "Café, leche, espuma de leche",
                orderDescription = "1 taza",
                price = 3.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 32L,
                name = "Latte",
                imageUrl = R.drawable.brownie_transparent,
                description = "Café latte suave y cremoso con un toque de leche al vapor.",
                ingredients = "Café, leche",
                orderDescription = "1 taza",
                price = 3.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 33L,
                name = "Té Verde",
                imageUrl = R.drawable.brownie_transparent,
                description = "Té verde refrescante y saludable, rico en antioxidantes.",
                ingredients = "Té verde",
                orderDescription = "1 taza",
                price = 2.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 34L,
                name = "Té Negro",
                imageUrl = R.drawable.brownie_transparent,
                description = "Té negro fuerte y aromático, perfecto para cualquier momento del día.",
                ingredients = "Té negro",
                orderDescription = "1 taza",
                price = 2.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 35L,
                name = "Té de Frutas",
                imageUrl = R.drawable.brownie_transparent,
                description = "Té de frutas refrescante con una mezcla de sabores frutales.",
                ingredients = "Mezcla de frutas, té",
                orderDescription = "1 taza",
                price = 2.5,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 36L,
                name = "Chocolate Caliente",
                imageUrl = R.drawable.brownie_transparent,
                description = "Chocolate caliente cremoso, perfecto para los días fríos.",
                ingredients = "Leche, cacao, azúcar",
                orderDescription = "1 taza",
                price = 2.5,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 37L,
                name = "Agua Mineral",
                imageUrl = R.drawable.brownie_transparent,
                description = "Agua mineral refrescante, ideal para acompañar tus comidas.",
                ingredients = "Agua mineral",
                orderDescription = "1 botella",
                price = 1.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 38L,
                name = "Limonada",
                imageUrl = R.drawable.brownie_transparent,
                description = "Limonada fresca y refrescante, perfecta para un día caluroso.",
                ingredients = "Agua, limón, azúcar",
                orderDescription = "1 vaso",
                price = 1.5,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 39L,
                name = "Coquita",
                imageUrl = R.drawable.brownie_transparent,
                description = "Bebida refrescante.",
                ingredients = "Azúcar y colorante",
                orderDescription = "350 ml",
                price = 0.7,
                isFavourite = false,
                category = "bebidas"
            ),
            Pan(
                id = 16L,
                name = "Pastel de Chocolate",
                imageUrl = R.drawable.brownie_transparent,
                description = "Delicioso pastel de chocolate con capas de esponjoso bizcocho y crema de chocolate.",
                ingredients = "Harina, azúcar, cacao, huevos, mantequilla, crema de chocolate",
                orderDescription = "1 pastel",
                price = 15.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 17L,
                name = "Pastel de Vainilla",
                imageUrl = R.drawable.brownie_transparent,
                description = "Clásico pastel de vainilla con un suave bizcocho y crema de vainilla.",
                ingredients = "Harina, azúcar, huevos, mantequilla, crema de vainilla",
                orderDescription = "1 pastel",
                price = 14.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 18L,
                name = "Tarta de Manzana",
                imageUrl = R.drawable.brownie_transparent,
                description = "Tarta de manzana con un relleno dulce de manzanas y canela.",
                ingredients = "Harina, azúcar, manzanas, canela, mantequilla",
                orderDescription = "1 tarta",
                price = 12.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 19L,
                name = "Tarta de Fresa",
                imageUrl = R.drawable.brownie_transparent,
                description = "Tarta fresca de fresa con una base crujiente y crema pastelera.",
                ingredients = "Harina, azúcar, fresas, crema pastelera, mantequilla",
                orderDescription = "1 tarta",
                price = 13.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 20L,
                name = "Tarta de Queso",
                imageUrl = R.drawable.brownie_transparent,
                description = "Suave tarta de queso con una base de galleta crujiente.",
                ingredients = "Queso crema, azúcar, huevos, galletas, mantequilla",
                orderDescription = "1 tarta",
                price = 14.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 21L,
                name = "Tarta de Limón",
                imageUrl = R.drawable.brownie_transparent,
                description = "Tarta de limón con un relleno cremoso y un toque de merengue.",
                ingredients = "Harina, azúcar, limón, huevos, mantequilla, merengue",
                orderDescription = "1 tarta",
                price = 13.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 22L,
                name = "Donas Glaseadas",
                imageUrl = R.drawable.brownie_transparent,
                description = "Donas suaves y esponjosas con un glaseado dulce.",
                ingredients = "Harina, azúcar, leche, huevos, mantequilla, glaseado",
                orderDescription = "1 dona",
                price = 1.5,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 23L,
                name = "Donas de Chocolate",
                imageUrl = R.drawable.brownie_transparent,
                description = "Donas suaves cubiertas con un glaseado de chocolate.",
                ingredients = "Harina, azúcar, leche, huevos, mantequilla, glaseado de chocolate",
                orderDescription = "1 dona",
                price = 1.5,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 24L,
                name = "Galletas de Chispas de Chocolate",
                imageUrl = R.drawable.brownie_transparent,
                description = "Galletas crujientes con deliciosas chispas de chocolate.",
                ingredients = "Harina, azúcar, mantequilla, chispas de chocolate, huevos",
                orderDescription = "1 paquete",
                price = 3.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 25L,
                name = "Galletas de Avena",
                imageUrl = R.drawable.brownie_transparent,
                description = "Galletas saludables y crujientes hechas con avena.",
                ingredients = "Avena, harina, azúcar, mantequilla, huevos",
                orderDescription = "1 paquete",
                price = 3.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 26L,
                name = "Galletas de Mantequilla",
                imageUrl = R.drawable.brownie_transparent,
                description = "Galletas suaves y deliciosas con un sabor rico a mantequilla.",
                ingredients = "Harina, azúcar, mantequilla, huevos",
                orderDescription = "1 paquete",
                price = 3.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 27L,
                name = "Croissants Rellenos de Chocolate",
                imageUrl = R.drawable.brownie_transparent,
                description = "Croissants crujientes rellenos con chocolate fundido.",
                ingredients = "Harina, mantequilla, azúcar, chocolate, levadura",
                orderDescription = "1 croissant",
                price = 2.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 28L,
                name = "Croissants Rellenos de Crema",
                imageUrl = R.drawable.brownie_transparent,
                description = "Croissants crujientes rellenos con crema pastelera.",
                ingredients = "Harina, mantequilla, azúcar, crema pastelera, levadura",
                orderDescription = "1 croissant",
                price = 2.0,
                isFavourite = false,
                category = "postres"
            ),
            Pan(
                id = 2L,
                name = "Salchicha de Carne",
                imageUrl = R.drawable.croissant,
                description = "Salchichas elaboradas con carne de res, ideales para parrilladas y desayunos.",
                ingredients = "Carne de res, especias",
                orderDescription = "500 g",
                price = 4.0,
                isFavourite = false,
                category = "embutidos"
            ),

            Pan(
                id = 3L,
                name = "Salchicha de Pollo",
                imageUrl = R.drawable.croissant,
                description = "Salchichas ligeras hechas de carne de pollo, perfectas para una opción más saludable.",
                ingredients = "Carne de pollo, especias",
                orderDescription = "500 g",
                price = 3.5,
                isFavourite = false,
                category = "embutidos"
            ),

            Pan(
                id = 4L,
                name = "Mortadela de Carne",
                imageUrl = R.drawable.croissant,
                description = "Mortadela tradicional hecha con carne de res, un clásico para sándwiches.",
                ingredients = "Carne de res, especias",
                orderDescription = "250 g",
                price = 2.5,
                isFavourite = false,
                category = "embutidos"
            ),

            Pan(
                id = 5L,
                name = "Mortadela de Pollo",
                imageUrl = R.drawable.croissant,
                description = "Mortadela ligera hecha con carne de pollo, perfecta para una opción más saludable.",
                ingredients = "Carne de pollo, especias",
                orderDescription = "250 g",
                price = 2.0,
                isFavourite = false,
                category = "embutidos"
            ),

            Pan(
                id = 6L,
                name = "Jamón",
                imageUrl = R.drawable.croissant,
                description = "Jamón de alta calidad, ideal para sándwiches y ensaladas.",
                ingredients = "Carne de cerdo, especias",
                orderDescription = "200 g",
                price = 3.0,
                isFavourite = false,
                category = "embutidos"
            ),
            Pan(
                id = 10L,
                name = "Leche Descremada",
                imageUrl = R.drawable.carrot_cake,
                description = "Leche descremada, ideal para una dieta baja en grasas.",
                ingredients = "Leche descremada",
                orderDescription = "1 litro",
                price = 1.5,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 11L,
                name = "Leche Entera",
                imageUrl = R.drawable.carrot_cake,
                description = "Leche entera, rica en nutrientes y perfecta para toda la familia.",
                ingredients = "Leche entera",
                orderDescription = "1 litro",
                price = 1.7,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 12L,
                name = "Leche Semidescremada",
                imageUrl = R.drawable.carrot_cake,
                description = "Leche semidescremada, el equilibrio perfecto entre sabor y salud.",
                ingredients = "Leche semidescremada",
                orderDescription = "1 litro",
                price = 1.6,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 13L,
                name = "Yogurt de Fresa",
                imageUrl = R.drawable.carrot_cake,
                description = "Yogurt cremoso con sabor a fresa, ideal para desayunos y meriendas.",
                ingredients = "Leche, fresa, azúcar, cultivos lácticos",
                orderDescription = "200 g",
                price = 1.2,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 14L,
                name = "Yogurt de Mora",
                imageUrl = R.drawable.carrot_cake,
                description = "Yogurt cremoso con sabor a mora, perfecto para una merienda saludable.",
                ingredients = "Leche, mora, azúcar, cultivos lácticos",
                orderDescription = "200 g",
                price = 1.2,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 15L,
                name = "Yogurt de Durazno",
                imageUrl = R.drawable.carrot_cake,
                description = "Yogurt cremoso con sabor a durazno, ideal para un desayuno rápido.",
                ingredients = "Leche, durazno, azúcar, cultivos lácticos",
                orderDescription = "200 g",
                price = 1.2,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 7L,
                name = "Queso Cheddar",
                imageUrl = R.drawable.carrot_cake,
                description = "Queso cheddar de sabor fuerte y textura firme, perfecto para hamburguesas y nachos.",
                ingredients = "Leche de vaca, sal, cultivos lácticos",
                orderDescription = "200 g",
                price = 5.0,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 8L,
                name = "Queso Mozzarella",
                imageUrl = R.drawable.carrot_cake,
                description = "Queso mozzarella suave y cremoso, ideal para pizzas y ensaladas.",
                ingredients = "Leche de vaca, sal, cultivos lácticos",
                orderDescription = "200 g",
                price = 4.5,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 9L,
                name = "Queso Parmesano",
                imageUrl = R.drawable.carrot_cake,
                description = "Queso parmesano envejecido, con un sabor intenso y textura granulada, perfecto para pastas.",
                ingredients = "Leche de vaca, sal, cultivos lácticos",
                orderDescription = "200 g",
                price = 6.0,
                isFavourite = false,
                category = "lacteos"
            ),
            Pan(
                id = 39L,
                name = "Mermelada de Fresa",
                imageUrl = R.drawable.americano_small,
                description = "Mermelada de fresa casera, perfecta para untar en tus panes y tostadas.",
                ingredients = "Fresas, azúcar, limón",
                orderDescription = "1 frasco",
                price = 3.0,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 40L,
                name = "Mermelada de Durazno",
                imageUrl = R.drawable.americano_small,
                description = "Mermelada de durazno casera, ideal para acompañar tus desayunos.",
                ingredients = "Duraznos, azúcar, limón",
                orderDescription = "1 frasco",
                price = 3.0,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 41L,
                name = "Mermelada de Naranja",
                imageUrl = R.drawable.americano_small,
                description = "Mermelada de naranja casera, perfecta para un toque cítrico en tus comidas.",
                ingredients = "Naranjas, azúcar, limón",
                orderDescription = "1 frasco",
                price = 3.0,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 42L,
                name = "Mantequilla",
                imageUrl = R.drawable.americano_small,
                description = "Mantequilla fresca y cremosa, perfecta para untar o cocinar.",
                ingredients = "Leche, sal",
                orderDescription = "1 paquete",
                price = 2.5,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 43L,
                name = "Nutella",
                imageUrl = R.drawable.americano_small,
                description = "Crema de avellanas y chocolate, ideal para untar en pan o como ingrediente en postres.",
                ingredients = "Avellanas, cacao, azúcar, leche",
                orderDescription = "1 frasco",
                price = 4.0,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 44L,
                name = "Miel",
                imageUrl = R.drawable.americano_small,
                description = "Miel pura y natural, perfecta para endulzar tus bebidas y alimentos.",
                ingredients = "Miel",
                orderDescription = "1 frasco",
                price = 5.0,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 45L,
                name = "Empanadas de Carne",
                imageUrl = R.drawable.americano_small,
                description = "Empanadas rellenas de carne, ideales para una merienda o comida rápida.",
                ingredients = "Harina, carne, especias, cebolla",
                orderDescription = "1 empanada",
                price = 2.0,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 46L,
                name = "Empanadas de Pollo",
                imageUrl = R.drawable.americano_small,
                description = "Empanadas rellenas de pollo, perfectas para una comida ligera.",
                ingredients = "Harina, pollo, especias, cebolla",
                orderDescription = "1 empanada",
                price = 2.0,
                isFavourite = false,
                category = "otros"
            )
        )
    }
}
