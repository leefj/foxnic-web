package org.github.foxnic.web.framework.licence;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.CP;

import java.lang.reflect.Method;

public class LicenceProxy {

    public static Object KE = null;
    public static Method KEM = null;
    public static Object LO = null;
    public static String LICENCE_DATA = null;
    public static String VnV_CODE=null;
    public static Long VnV_TICK=0L;
	public static String SN = "0rEsX3yaeJWiDqrUUz+wcARx+jB/ATPrhIiX2sFl3RyrOmGt6DbtXWDBrXrlBPoXrRsoNCk55k4qVlqHLqw77SFUb/TjXE9/GnFRrbKTcbCK2AKC+rxZpsr23B8MndikkMaM+Rp1nHOKCAOuJIqPlWLXiLDPEV1EhwVDRfrVttd9tr+HU9dXH7t0hOK5er72KAK+ERLg0YxJZ5if4tLuWHecSgHDX2WgcWABqAm2TA9OrVP8HkLX9v1llaJTTzoauU0QglI7URepNhAkh99xH7ZbqqxbbLDmrNsk4DWHGcR0mim0JuMN3wFt1fJ6gy45xtxNQ7irCkfWh2y74E1rxasA77ddtc2kWeLWybnlQZdzxb62ConU4ItqXrILjPvv7EIB5rWi40iDuZJd+HIZlFOsvmhw5QKlp7ve4o0gqeFnR6180CGEzd4fN9htpob2q8PXKtfGx7aGP+afe2nDp7LQSkiq3c4fCg+N3vUTzJVe1PpVNmZj+6PYAAEeaz+BuMMU0M1hXDqbBGRZgP+6D9Mi90uRxDQ3gvUR1Oe2SsPrVkdH/ha03k8CZZdXRJirQlOvFK90K0AfBHPv5DXB03rBSnWxjf4CrhAyPQQEu6tlbv9ykMryzu4PsGrFciHRAldMC726aI+o4xUt0VzgeXaK2tCf71RAKeIdKrP9CO7n0nFmMXi/u0cYw4kZY3OquCNLSYoQtVbeCpFN7qkVZz01pgTCuOT+0E615djigHplbv9ykMryzu4PsGrFciHRkFPe4UIE2vaobAQU7BTzJnw2sIjO9GwhyDIlpqd29JX4UEUD3+af8MUPvNPkxi6m6VfBYgPijouwqWXvKcXj8ruDAP6DORQXUeKwDHCcQ3RjFec0F15sPlYLQRDh/jGpFm0X79tk48bQ8rfhwn4Smft4JcQ/+meUAmikNV7cJeVoOEho+ntLIKh9G0E0W+e6CnB3FAPCg5qtSdp7fvTCCIYeaqpDh3YAvrbPAYQSUVA+tNMuGUaamFbkQNeWLJwBPRfgthihHtzu4klW8DGoPn1q5kXOV6CtGwCjr7BJYA8WYEoA2R0ux0MF7sQYgkq4RDIiV54dfz4rrVx79U5XGzwVt29yYH9mWcrb/DyrBSE/37lKJlBlzbXx34UucVdWd5xKAcNfZaBxYAGoCbZMD2soF6RLuDwSCtY9h+BoPSL6vueRowAKh61cN/hgMGvWOCsa5B/BlY28JUIZ37HPKSTybY5ro1xj6totBs02v60yfFulZW+nSqKDNJZ+cIF4Fyq9JmRpcbFE4g2FjJ9dt57ESCnd/nMRyH6htcN65sIm2hGB0EPJzFvOEgJydSePr67v+u6s/gY12YY06SO5b6quMxYyhCXBTxf74Km0NFpeRRAg8u7QM/XYncQR2s0/1OLsBJnDCs0knFLxGlz/vyR0iDSnYtxfN2T5ZIWe1Jn8/bA/rl70ia92lz7OTOALH++rGccBeZqGxrvA0JrdhiAuaXPJsX14PZW30q6tuUmWs4g2J7ivd3VVBwvklnLqtnz9Jm53z76CHuK3gabkCR6Ow0CIGGf/WSEPRvLOu18dg7Iysy722ax/WC3o3n7LAVbTZpOZKzKVnXhYdFZmnj4X0GjztR9gH+uuATSuRrHkK8ffbTmFbgXq/zFnpCvZz1gNv2G81QjTwfGbA0brM0Fu2ECJiIS9Zur26ZSodQaTftmQiHgh34ZzkuhBHeJMsBuSZDrnLuieuHabpLFiogvVyogsCxQYF8jAFCzfbZfwvF0DVyhwMDZrc4VMBs7OXVHX3PiXS+hpj9ikVF309B5/fA25wNF5YsipFJeUJmlwBRfuAOTpyxPpx+CWR4SpwZZ//VKrWztQQcXlYQZ05z9j8EAVIC3R62VYn8LNEat3jHR01eod6ynu6hw3oAzKRiyjlP4fin0qYzNX00Esa7ZbqqxbbLDmrNsk4DWHGcTUo7km0pPSeUO4yQJrxLUt9K8oehkItCGNlvzMLuEvX8rgLk9r9xRDdj4P9bnh/sny+mCOacu53qtWkS/DTzpc6gHHXkK6/JyJO3Tq/CJ4OIhp6W0E6q/vjD1i5uBeuptFIk9FPRKlNNXZ8UQq+KRgC9XKiCwLFBgXyMAULN9tl9jf5WdAPQ6zZxqk45cLcyS3JApyr4vtuEATrqRW9kOZ8lp2AVnrfcVywiWyVOrgXrIvoWXf/HpEM7zpSaqB1DLsYNGOwuYoOt33jRaf8RY0ivT6qGu0Rgy2QYxbqnMEipJalDPkf3MmhnS5i2cxL2Ef5MbHnNJir7u8hLH5lgInALR5Bwl3Abz22Xh4AzIDyKvD1yrXxse2hj/mn3tpw6eR7X3yflccdqxg1lSWYnOKZkajDA4vSMi2jcsyb5rv7DdluB4qSU6CDuQdnwqV+2QH1MLLnAmfL2h69j2eONO2tluqrFtssOas2yTgNYcZxF7CXp/X5Ech6AU32w/x3r+6+DLrN7A/fFNNVhTlYcdJNB48nwERC+KGm/5G4Nws1lPRvaQ3fUqa/8gix3DHO4nqAcdeQrr8nIk7dOr8Ing4xP06IcevkZ2RITikzpep+kKpIK4euHlvOcPTY/6V3xmFVJW9dzx4SQcEaH0QgzOW6rzRseAViAvoDpV6m/znSofJ6ewH6BheZh+bjSyWIV9Cju2EWbVuh3e8GNoHDIRNnw4bAG3K6RFB6v97ewxjJUzrr129W55H17P360HOAUE1GU4DY8skPaEl7dvSA7IPjoug0P64WL2p6vKlDbb4VGFrveVG0m4E4MlZuSiFr7BkYoyCmXDloz6Br9IhVc3hLJdb6YCET/xu0rzvJJUO1x3Km7NKuDtdKhEOriVP9gQ9/bq7kB9mXeTVfcZK+EI28C7SlKSx3r4tMBcjKJr20ZwOrSEOXysufIxad8WZBhV4sN/ajtoWVe4dv2zU1KKN/qoOFZsj428ehxPPg/NWFo9oW9VdCNI/wpP5CH+htaluonMoPp9tE4i1Caj9iXmVF51r9/p0KCCqMp5d617fP6irXKvuygNQU35tFpygJonqAcdeQrr8nIk7dOr8Ing4sfdMbBu5Y2EceuVcY25vKtte+C24jROcoPHfZZsBxaQg6R4HhnzMn84tpEFsjIjHpBjgJCu2rZCAUwphlpHJl+DQS4keV1lbvbg0AAtClFXqAcdeQrr8nIk7dOr8Ing45mO9P4X1+wG6wpvCV9TWuYcenmsjtN+ieXpq1R35mN4L1cqILAsUGBfIwBQs322XTLeGIwAx0o0cqDqIN3hMgYqPGafyYq8JXBJLzCyOa3xgcwtlQzcL3lwDMIdAnPbS+FBFA9/mn/DFD7zT5MYupt+BOr+5GCo1vMYaLX/H6bEDDIIExnntg28LEFx5CI/k8C7SlKSx3r4tMBcjKJr20SCESdsQ20O+N7VzCIPS9oZsZyzNugM2KNJFi0+ky/dLUXh/aYgmqTctbulT8BqHd7t4z581+tBDdDOvf7Ifhh333Y42zllnlK8IsaNeTR1bN+PptF2bUO03Hcra7xfUCedmE0BrzMj69LPbZiGopz7hRKcymW1QqEwFdaHkuWDznBkTvZuEkhmduu3JctJjqcHlVj7VLWfP2XGG21yKvF/+A+K9bZMJ1zSzrgmU3AEdGJUW5b5G9vm24Irj9ky0ZGeP24zeQZ2YBcs77+fwFQe4K5laKr3jqrGKtMqvriiZmyr8p4Pwg1grPT+TX0qfdhYlUSzbhyTomCltBHHMpktzxF+WttTIXjNUX1rR34vRYMTUM9/KizI3L8/vUmxn4Vl5yIGWM56zuOL9MmGQqyU/iW7zy8gm3VLf5QMPv9QnlWtpaj5dJGDDofIQYNPPerd2WJyepy8t3StknQfzKPz796C6oqbsn+fSm9ZqSaBYHoJylzlWzr0sk00D+VWqg31q5kXOV6CtGwCjr7BJYA8boqJmtPjaV0C/SmOiK5VAjkBQhEAZTPKrhjs3s4UwdA9X9SG0aBq8dbsHW5qN/CFaysAEgmkamA92GXSxaUi3Dt1S5uT0CJF04DilLJb2tTrDwq+SBQXgNFJPQQ6ReuZShXt8/pSTQd+rcq//Q/bQ0S7Cm8TEVaKpJG8WSDwuhV2jD8XqexpaD4pEASJVHG2bE6EGnvv+qGa6rn6TN6Z5iIJ4HnTz1gyUFpgO3B2VhKmwpTyxE77gWm8Bg1iWmOgmYzkjVjCS6VxC7cgbw3XfAmNb/LJvCJVktz8FLd7XfqscBuEFiau6u3wwdvfBNiOY1bKsNThkGlg5gyBpItViFdjGyjNwEPK+6vpkQhdn/ZwkfWr50T4S7iedqlhO83vInHzkvP9QAJ/2xrP2zz3nDlEZyi17u+9NtyqubcHi7fOV1QWLDLIDH7oEpXqbvT+Qxoz5GnWcc4oIA64kio+VYteIsM8RXUSHBUNF+tW215e7xChk7p06YJlomfbOxCOEEknU56GFff6+yBtOn/k0gCaFdQbohnO/CDyjF4Z477CrWLM9gaRE4kiY44n90iBY9kDLw9BFoBBRxK/1pbUBzyAnEOa7h+6eLpqeJmchEdKlACW6iAS4XIbrX3WI1dQjvdWoPOYJbM44kH0wFuWz4S/67vfQdA/1pxtgFlrP3IAmhXUG6IZzvwg8oxeGeO9RfBezzibEtjMGDiQmRSwlOeoyXIXjcA0UNh3ODLMh3oAmhXUG6IZzvwg8oxeGeO9NXMhF0QVvtR5szhZEKT58XnkTJ/DAatZvyyYuoNzwsl0qe46Jsp2oRDN69AY6xgMGn36dMZqnIEu9jTVgm/1mU/oS09YnPJr85r9/uCTMTh2DsjKzLvbZrH9YLejefsuYLvqZglMe0fzu8cA1fCKuBRgFnAZhFraGAqb20cXhKe9tEEdbXTZdPwP9cdTv5Ar318N2T5vYK+hoK5F+vw1gM8pO+KfoFKumZYYEo5bf93SCAZ0I4VMJ34Ucbo9lxQl9vHrnArMDozK8AJl0mIwUIsGTem5OW200mHwEoK0Foch43TVFIOEMgSSibj+BvCY+8a6/+fYMm3tK32qHF2qDDJbuEWrvMYJsY1EcU71siFm+yqmZwgcadP/szXYkK7L7QxErx9onWACWlfkJnKvikNiyuZpJg9cCbtXivqZeb3bYcHg6XNqajrAXGDOFK5U=";

    public static void reset() {
        try {
            CP.getInstance().reset();
        } catch (Exception e) {
            Logger.error("许可证重置失败",e);
        }
    }

    public static JSONObject getLicence() {
        try {
            return CP.getInstance().getConfig();
        } catch (Exception e) {
            Logger.error("许可读取置失败",e);
            return null;
        }
    }

    /**
     * 获得模块配置，建议把这个方法拷贝到自己的模块去
     * */
    public static JSONObject getModuleConfig(String code) {
        if(LicenceProxy.KE==null || LicenceProxy.KEM==null) return null;
        try {
            return  (JSONObject)LicenceProxy.KEM.invoke(LicenceProxy.KE,code);
        } catch (Exception e) {
            Logger.error("许可读模块取置失败",e);
            return null;
        }
    }


}