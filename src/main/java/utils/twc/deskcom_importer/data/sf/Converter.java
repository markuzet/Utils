package utils.twc.deskcom_importer.data.sf;

import utils.twc.deskcom_importer.data.Case;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Converter {
    public static SfCase convertToSf(Case c) {
        SfCase sfCase = new SfCase();

        sfCase.setSubject(c.getBlurb());

        return sfCase;
    }
}
