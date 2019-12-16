package com.hongcn.mcolorselector;

/**
 * ---------->_<-------------
 *
 * @author : hongcn
 * date : 2019/12/9 10:46
 * --------------------------
 * Description:
 */
public class MaterialColorPolicy {

    public static class ColorVariety {
        public static final int RED = 11;
        public static final int PINK = 12;
        public static final int PURPLE = 13;
    }

    public static class ColorGamut {
        public static final int MATERIAL_50 = 0;
        public static final int MATERIAL_100 = 1;
        public static final int MATERIAL_200 = 2;
        public static final int MATERIAL_300 = 3;
        public static final int MATERIAL_400 = 4;
        public static final int MATERIAL_500 = 5;
        public static final int MATERIAL_600 = 6;
        public static final int MATERIAL_700 = 7;
        public static final int MATERIAL_800 = 8;
        public static final int MATERIAL_900 = 9;
        public static final int MATERIAL_A100 = 10;
        public static final int MATERIAL_A200 = 11;
        public static final int MATERIAL_A400 = 12;
        public static final int MATERIAL_A700 = 13;
    }

    /**
     * gamut stype.
     */
    public static final int GAMUT_MAT_SINGLE = 0;
    public static final int GAMUT_MAT_LESS = 1;
    public static final int GAMUT_MAT_WHOLE = 2;


    public static MaterialColor.ColorGamut[] getGamut(int gamutType) {
        MaterialColor.ColorGamut[] colos = MaterialColor.createGamutArray();
        if (gamutType == GAMUT_MAT_LESS) {
            MaterialColor.ColorGamut[] less = new MaterialColor.ColorGamut[4];
            less[0] = colos[3];
            less[1] = colos[5];
            less[2] = colos[7];
            less[3] = colos[9];
            return less;
        }
        return colos;
    }


    public static String[][] getColorData() {
        return new String[][]{
                MaterialColor.getRed(),
                MaterialColor.getPink(),
                MaterialColor.getPurple(),
                MaterialColor.getDeepPurple(),
                MaterialColor.getIndigo(),
                MaterialColor.getBlue(),
                MaterialColor.getLightBlue(),
                MaterialColor.getCyan(),
                MaterialColor.getTeal(),
                MaterialColor.getGreen(),
                MaterialColor.getLightGreen(),
                MaterialColor.getLime(),
                MaterialColor.getYellow(),
                MaterialColor.getAmber(),
                MaterialColor.getOrange(),
                MaterialColor.getDeepOrange(),
                MaterialColor.getBrown(),
                MaterialColor.getGrey(),
                MaterialColor.getBlueGrey()};
    }
}
