package com.hongcn.mcolorselector;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/4 18:00
 * --------------------------
 * Description:
 */

import android.util.SparseArray;

import com.hongcn.mcolorselector.MaterialColorPolicy.ColorVariety;

public class MaterialColor {

    private static String[] red = null;
    private static String[] pink = null;
    private static String[] purple = null;
    private static String[] deepPurple = null;
    private static String[] indigo = null;

    private static String[] blue = null;
    private static String[] lightBlue = null;
    private static String[] cyan = null;
    private static String[] teal = null;
    private static String[] green = null;
    private static String[] lightGreen = null;

    private static String[] lime = null;
    private static String[] yellow = null;
    private static String[] amber = null;
    private static String[] orange = null;
    private static String[] deepOrange = null;
    private static String[] brown = null;

    private static String[] grey = null;
    private static String[] blueGrey = null;

    private static SparseArray<String[]> colorArray = new SparseArray<>(50);


    public static String[] getRed() {
        if (red == null) {
            red = new String[]{
                    "#ffebee", // 50
                    "#ffcdd2", // 100
                    "#ef9a9a", // 200
                    "#e57373", // 300
                    "#ef5350", // 400
                    "#f44336", // 500
                    "#e53935", // 600
                    "#d32f2f", // 700
                    "#c62828", // 800
                    "#b71c1c", // 900
                    "#ff8a80", // A100
                    "#ff5252", // A200
                    "#ff1744", // A400
                    "#d50000", // A700
            };
        }
        // colorArray.put(ColorVariety.RED, red);
        return red;
    }

    public static String[] getPink() {
        if (pink == null) {
            pink = new String[]{
                    "#fce4ec", "#f8bbd0", "#f48fb1", "#f06292", "#ec407a", "#e91e63", "#d81b60", "#c2185b", "#ad1457", "#880e4f",
                    "#ff80ab", "#ff4081", "#f50057", "#c51162"};

            colorArray.put(ColorVariety.PINK, pink);
        }
        return pink;
    }

    public static String[] getPurple() {
        if (purple == null) {
            purple = new String[]{
                    "#f3e5f5",
                    "#e1bee7",
                    "#ce93d8",
                    "#ba68c8",
                    "#ab47bc",
                    "#9c27b0",
                    "#8e24aa",
                    "#7b1fa2",
                    "#6a1b9a",
                    "#4a148c",
                    "#ea80fc",
                    "#e040fb",
                    "#d500f9",
                    "#aa00ff",
            };
        }
        colorArray.put(ColorVariety.PURPLE, purple);
        return purple;
    }

    public static String[] getDeepPurple() {
        if (deepPurple == null) {
            deepPurple = new String[]{
                    "#ede7f6",
                    "#d1c4e9",
                    "#b39ddb",
                    "#9575cd",
                    "#7e57c2",
                    "#673ab7",
                    "#5e35b1",
                    "#512da8",
                    "#4527a0",
                    "#311b92",
                    "#b388ff",
                    "#7c4dff",
                    "#651fff",
                    "#6200ea"
            };
        }
        return deepPurple;
    }

    public static String[] getIndigo() {
        if (indigo == null) {
            indigo = new String[]{
                    "#e8eaf6",
                    "#c5cae9",
                    "#9fa8da",
                    "#7986cb",
                    "#5c6bc0",
                    "#3f51b5",
                    "#3949ab",
                    "#303f9f",
                    "#283593",
                    "#1a237e",
                    "#8c9eff",
                    "#536dfe",
                    "#3d5afe",
                    "#304ffe"
            };
        }
        return indigo;
    }

    public static String[] getBlue() {
        if (blue == null) {
            blue = new String[]{
                    "#e3f2fd",
                    "#bbdefb",
                    "#90caf9",
                    "#64b5f6",
                    "#42a5f5",
                    "#2196f3",
                    "#1e88e5",
                    "#1976d2",
                    "#1565c0",
                    "#0d47a1",
                    "#82b1ff",
                    "#448aff",
                    "#2979ff",
                    "#2962ff"
            };
        }
        return blue;
    }

    public static String[] getLightBlue() {
        if (lightBlue == null) {
            lightBlue = new String[]{
                    "#e1f5fe",
                    "#b3e5fc",
                    "#81d4fa",
                    "#4fc3f7",
                    "#29b6f6",
                    "#03a9f4",
                    "#039be5",
                    "#0288d1",
                    "#0277bd",
                    "#01579b",
                    "#80d8ff",
                    "#40c4ff",
                    "#00b0ff",
                    "#0091ea"
            };
        }

        return lightBlue;
    }

    public static String[] getCyan() {
        if (cyan == null) {
            cyan = new String[]{
                    "#e0f7fa",
                    "#b2ebf2",
                    "#80deea",
                    "#4dd0e1",
                    "#26c6da",
                    "#00bcd4",
                    "#00acc1",
                    "#0097a7",
                    "#00838f",
                    "#006064",
                    "#84ffff",
                    "#18ffff",
                    "#00e5ff",
                    "#00b8d4"
            };
        }
        return cyan;
    }

    public static String[] getTeal() {
        if (teal == null) {
            teal = new String[]{
                    "#e0f7fa",
                    "#b2ebf2",
                    "#80deea",
                    "#4dd0e1",
                    "#26c6da",
                    "#00bcd4",
                    "#00acc1",
                    "#0097a7",
                    "#00838f",
                    "#006064",
                    "#84ffff",
                    "#18ffff",
                    "#00e5ff",
                    "#00b8d4"
            };
        }

        return teal;
    }

    public static String[] getGreen() {
        if (green == null) {
            green = new String[]{
                    "#e8f5e9",
                    "#c8e6c9",
                    "#a5d6a7",
                    "#81c784",
                    "#66bb6a",
                    "#4caf50",
                    "#43a047",
                    "#388e3c",
                    "#2e7d32",
                    "#1b5e20",
                    "#b9f6ca",
                    "#69f0ae",
                    "#00e676",
                    "#00c853"
            };
        }
        return green;
    }

    public static String[] getLightGreen() {
        if (lightGreen == null) {
            lightGreen = new String[]{
                    "#f1f8e9",
                    "#dcedc8",
                    "#c5e1a5",
                    "#aed581",
                    "#9ccc65",
                    "#8bc34a",
                    "#7cb342",
                    "#689f38",
                    "#558b2f",
                    "#33691e",
                    "#ccff90",
                    "#b2ff59",
                    "#76ff03",
                    "#64dd17"
            };
        }
        return lightGreen;
    }

    public static String[] getLime() {
        if (lime == null) {
            lime = new String[]{
                    "#f9fbe7",
                    "#f0f4c3",
                    "#e6ee9c",
                    "#dce775",
                    "#d4e157",
                    "#cddc39",
                    "#c0ca33",
                    "#afb42b",
                    "#9e9d24",
                    "#827717",
                    "#f4ff81",
                    "#eeff41",
                    "#c6ff00",
                    "#aeea00"
            };
        }
        return lime;
    }

    public static String[] getYellow() {
        if (yellow == null) {
            yellow = new String[]{
                    "#fffde7",
                    "#fff9c4",
                    "#fff59d",
                    "#fff176",
                    "#ffee58",
                    "#ffeb3b",
                    "#fdd835",
                    "#fbc02d",
                    "#f9a825",
                    "#f57f17",
                    "#ffff8d",
                    "#ffff00",
                    "#ffea00",
                    "#ffd600"
            };
        }
        return yellow;
    }

    public static String[] getAmber() {
        if (amber == null) {
            amber = new String[]{"#fff8e1",
                    "#ffecb3",
                    "#ffe082",
                    "#ffd54f",
                    "#ffca28",
                    "#ffc107",
                    "#ffb300",
                    "#ffa000",
                    "#ff8f00",
                    "#ff6f00",
                    "#ffe57f",
                    "#ffd740",
                    "#ffc400",
                    "#ffab00"
            };
        }
        return amber;
    }

    public static String[] getOrange() {
        if (orange == null) {
            orange = new String[]{
                    "#fff3e0",
                    "#ffe0b2",
                    "#ffcc80",
                    "#ffb74d",
                    "#ffa726",
                    "#ff9800",
                    "#fb8c00",
                    "#f57c00",
                    "#ef6c00",
                    "#e65100",
                    "#ffd180",
                    "#ffab40",
                    "#ff9100",
                    "#ff6d00"
            };
        }
        return orange;
    }

    public static String[] getDeepOrange() {
        if (deepOrange == null) {
            deepOrange = new String[]{
                    "#fbe9e7",
                    "#ffccbc",
                    "#ffab91",
                    "#ff8a65",
                    "#ff7043",
                    "#ff5722",
                    "#f4511e",
                    "#e64a19",
                    "#d84315",
                    "#bf360c",
                    "#ff9e80",
                    "#ff6e40",
                    "#ff3d00",
                    "#dd2c00"

            };
        }

        return deepOrange;
    }

    public static String[] getBrown() {
        if (brown == null) {
            brown = new String[]{
                    "#efebe9",
                    "#d7ccc8",
                    "#bcaaa4",
                    "#a1887f",
                    "#8d6e63",
                    "#795548",
                    "#6d4c41",
                    "#5d4037",
                    "#4e342e",
                    "#3e2723",
                    "#d7ccc8",
                    "#bcaaa4",
                    "#8d6e63",
                    "#5d4037"

            };
        }
        return brown;
    }

    public static String[] getGrey() {
        if (grey == null) {
            grey = new String[]{
                    "#fafafa",
                    "#f5f5f5",
                    "#eeeeee",
                    "#e0e0e0",
                    "#bdbdbd",
                    "#9e9e9e",
                    "#757575",
                    "#616161",
                    "#424242",
                    "#212121",
                    "#f5f5f5",
                    "#eeeeee",
                    "#bdbdbd",
                    "#616161"
            };
        }

        return grey;
    }

    public static String[] getBlueGrey() {
        if (blueGrey == null) {
            blueGrey = new String[]{
                    "#eceff1",
                    "#cfd8dc",
                    "#b0bec5",
                    "#90a4ae",
                    "#78909c",
                    "#607d8b",
                    "#546e7a",
                    "#455a64",
                    "#37474f",
                    "#263238",
                    "#cfd8dc", //100
                    "#b0bec5", //200
                    "#78909c", //400
                    "#455a64", //700
            };
        }

        return blueGrey;
    }


    static ColorGamut[] createGamutArray() {

        ColorGamut[] gamuts = new ColorGamut[14];
        gamuts[0] = new ColorGamut("Material 50", 0);
        gamuts[1] = new ColorGamut("Material 100", 1);
        gamuts[2] = new ColorGamut("Material 200", 2);
        gamuts[3] = new ColorGamut("Material 300", 3);
        gamuts[4] = new ColorGamut("Material 400", 4);
        gamuts[5] = new ColorGamut("Material 500", 5);
        gamuts[6] = new ColorGamut("Material 600", 6);
        gamuts[7] = new ColorGamut("Material 700", 7);
        gamuts[8] = new ColorGamut("Material 800", 8);
        gamuts[9] = new ColorGamut("Material 900", 9);
        gamuts[10] = new ColorGamut("Material A100", 10);
        gamuts[11] = new ColorGamut("Material A200", 11);
        gamuts[12] = new ColorGamut("Material A400", 12);
        gamuts[13] = new ColorGamut("Material A700", 13);

        return gamuts;
    }

    public static class ColorGamut {
        public String name;
        public int index;

        ColorGamut(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }
}

   
