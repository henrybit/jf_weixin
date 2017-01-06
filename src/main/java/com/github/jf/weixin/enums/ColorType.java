package com.github.jf.weixin.enums;

/**
 * 颜色种类<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public enum ColorType {
    /**
     * #63b359
     */
    COLOR010("Color010","#63b359"),

    /**
     *#2c9f67
     */
    COLOR020("Color020","#2c9f67"),

    /**
     *#509fc9
     */
    COLOR030("Color030","#509fc9"),

    /**
     *#5885cf
     */
    COLOR040("Color040","#5885cf"),

    /**
     *#9062c0
     */
    COLOR050("Color050","#9062c0"),

    /**
     *#d09a45
     */
    COLOR060("Color060","#d09a45"),

    /**
     *#e4b138
     */
    COLOR070("Color070","#e4b138"),

    /**
     *#ee903c
     */
    COLOR080("Color080","#ee903c"),

    /**
     *#f08500
     */
    COLOR081("Color081","#f08500"),

    /**
     *#a9d92d
     */
    COLOR082("Color082","#a9d92d"),

    /**
     *#dd6549
     */
    COLOR090("Color090","#dd6549"),

    /**
     *#cc463d
     */
    COLOR100("Color100","#cc463d"),

    /**
     *#cf3e36
     */
    COLOR101("Color101","#cf3e36"),

    /**
     * #5E6671
     */
    COLOR102("Color102","#5E6671");

    private String name;
    private String value;
    ColorType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }
}
