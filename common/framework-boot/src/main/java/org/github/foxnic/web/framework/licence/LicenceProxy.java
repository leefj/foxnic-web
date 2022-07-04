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
	public static String SN = "0rEsX3yaeJWiDqrUUz+wcARx+jB/ATPrhIiX2sFl3Rw3ebU/CsXgRaF77sg0AIu16mAu763P+iGFJ8TGcm1RQEr/waZQNKyEK0HehPbJb3Q6fuB1mnRCmUkblATMzI705X8xBlML1iV4Bw4JvRt1KGTxy/Abc4HE1HeGQdGB+iUVk78LPEXpOc08O3skiFdUIJooIuKej9c/FL7kRF3K8necSgHDX2WgcWABqAm2TA9O3SND0u9eaKnZDl2DNU8cDVRJgz0GfabGjusM6ArDT7ZbqqxbbLDmrNsk4DWHGcS8AFV9JPbwOrWSoqGIY1mkbPvfRKLQ1nv0f7JbT8h02KsA77ddtc2kWeLWybnlQZc5mnJgF1Vz1dCa5yh977lwkJg042tlapqzEK1uc2K2WVOsvmhw5QKlp7ve4o0gqeGCISMyGcF+fxBIh1Mp4ZvTnsRIKd3+cxHIfqG1w3rmwmbbUNWmioioPFRLYMf7ShkMdDPi05vgWYV+73oUv/f0C3kLaSeemHDFS6X/bCyrQ2G0rjkNVGlIGfAU1Gz/RHuR2bGoF77en4p8ELgUraHVnr7frGdnL+Mzw4iYDJ9kmTFD87NrY5RcpXiGi27ONlfiv4VT+mW4sRNU6mcYW0h4Pq8bQS+ziw72JlDey7/EpvhvzrwKw7l3oTU4MKjaJRv8/bA/rl70ia92lz7OTOALslsRpfcfXx/S9hveIYU6AU8O5KUzMeJ51I0qWjJ1yPpU64ZQSaNLUZjyWrqN9Ue3QxKWT17E4stbsyY/I1qSReoBx15CuvyciTt06vwieDiIaeltBOqv74w9YubgXrqblc/RZx9+7j0Gz/IBUbxqY7nnUrYaV8lXb+Tz1bRp+ZqjeCL2ogmTKufsz8cdwhTGnhiMJYfAKYeowWGTD39K1u7r0hX2950UFBCQgX78iSiTbR+aNrg5/jZQV306Qeh5FEf1iGvSUSeiczE0yubHVuBcJtHMvmBsXTXTBOUaZwNLmiYT/cEscXnbQhERoy8f1nbbGH1S/FFLh38hBlMnMjx8zZTHIC12UPOK8FbrZLHa5kGjjIV94j4veFWBPIsz+G/OvArDuXehNTgwqNolGwR94fHvnM7vuIcroB0QFpLL+mz/G5Dbv4vh4ZQKJkXg4MAw4vlcKMvLg3I3eVHfZh5CCeqnZCHvv21KN9mfvusL1cqILAsUGBfIwBQs322XfDdij8B3xPkHgg4smd9PxfCPuLv2LvDBeZhECsDXGPYzLrwG7IbbH18LBMgx/3DYL0bmcsqCumB6yHhExYwOsaOw7BHxPP4VK/JK2VkqhVw1wqGVtHX6T1n+50XdO0D4Aq/3U8816yV5wLGb3hth1IAmhXUG6IZzvwg8oxeGeO/5fFUZSi+lk0iRoizW1h88TIQCJEuKHV5y3nO/kgnRurB6M7fMKVL6khEg7AlXe4kdg7Iysy722ax/WC3o3n7L+CfuCHkkzI/mowD9tzdTZaNqLr6r0S8mJKW0iP1jg54iDGT6hidgDfIG6AH7H1Wn2YqujCgWNygtXMBGxTq7/Gz730Si0NZ79H+yW0/IdNgP/tL7D1gfVObkFRLYddWGar48dERvs9D7jqZ9CuDc9e02ayzdR2LnDSZ75Ox0+DD6T7YNJgFNbOeOR+hwFVvXDCsHhAC6SApeyO/Yy5EWrh8kxVSkOF9ktmzUMMB5bH8RT6K/JfVukHPc5rUKdqJY/Cy9bVYViZQhreYdu0hmMIAmhXUG6IZzvwg8oxeGeO+tcZIJ4IPtf9r8kIfjbOhTaPseCEcJxSe7i8wmA26J7A1L2BqHD93cS4VTeQou0wIBaP06xWWpVz2U5O2hbGOtMfpyeO/lua2DeIhW1EhZ66DEOATOMBO5meYQYejL19p/uDKHAO41ts2Vi61aU9wUbPvfRKLQ1nv0f7JbT8h02KsA77ddtc2kWeLWybnlQZeGQeAQZJSdYvJ/OBdkvYL9R70DPS+/HQG5gxeP5W5hd2/i7BZWTy3tX9Qy1CH2iZD2UsGzO24Xr4IOCr6znrX8q8PXKtfGx7aGP+afe2nDpwZVtjZ6eOd6Qkv6v3YglQiPw29X47Dvh454c1P/UAeldgriAWuvoEfH7VnA8iVandbkPsmIRr4QISnpeaonb2BPr0ibcG+x0eEoD1VgioaTWoNuyb4GBx0kEBNGLFoeXk0r0ueXDuDepiHSlwo2WShW0tLi7J1sstdN3gUjT5680pmEUKuWOOY+rNkWAa+w8SQgbkXh7zdhexzW7JD4b2+mOkueERcrsbtTc6D0HUgaJPTr7SOLgi0CbKMlE2qR48gzs+PIQc3GNG0ZnbskOSIcyyNhHwkqucVn/8jzDVpDKe18HqTlLujmDd0Vlg1FNfrgkfN/LBT6eJpgRvikuqqAJoV1BuiGc78IPKMXhnjvlzV1e3brtx8gHe9pcJJbBAvDi5pvaTXodXG5U1I+a21vdLaF5ap9bQE27OoTrySNGwbOMBTlAUi/KFOXPqpT8BNpj2HQ1PRgr7OHV1HQl8aexEgp3f5zEch+obXDeubCN81sp7yju8xgMX4pl8wgqO1YnECvA1oAmA+Ch9Po3fR5aWOpC9K5iNTxXx6FazLnOh96AN9M08nMSHBUJUjs8dZytCiC0rognhPrsM41zj7RYzY/rmNHBbeRWXrAk4LimHz7119AuJv+XgY00IjpfK7YmV/2PxgsWpQHubvzkuYb/EKLnW/bi9KiBQCkRCKdforzvZUEMxxb1iJfo/qPKgvVyogsCxQYF8jAFCzfbZcl2HSpcrtUhhSOfxLR8ZA9s5DO9t2uWNlLs96sP+NdNEccuuKuGP4n9aN5gJt9HoF8NrCIzvRsIcgyJaandvSV+FBFA9/mn/DFD7zT5MYuptleRcMGpk22kG4E3GpLe4SnH5D2FfeOjGujkN7pfFscVdhVDFXc+DcA57fh9g0cVqaklaiEf6OuEna3uL+m0BNtxx8/nANai50XO2Ikz13qN2n1Y1x0lk145h1VBiYCWFE6Wml8IHmLbI4wRPPTPcaexEgp3f5zEch+obXDeubCeCi74v+nUJgWu1SqtO1qsfpAHC/XBZU1B1cadI45PFADY2OhWxtAWV/IS8xelN/EQNUagRqAnkIlJ1SKoN+J7IvhmOR1nTZ6/59LnyDZsqCexEgp3f5zEch+obXDeubC37wh/s7mEqUl+TOZHExumTTFP9uA5e+l/Lne/41n8vyrw9cq18bHtoY/5p97acOnWkuZapcXLtBUGGzltsS3Lh+Oyw2HDIOH7nPEmoU4YjHqAcdeQrr8nIk7dOr8Ing42AF/KL2jjyZ0t4tP54FFI6AfTXyIzVQRXX+LEQxdvQNA8AhnL3HToG+s//YgmhlhtluqrFtssOas2yTgNYcZxLJUBousjmhYOUj4Lx6SB/uouX4D4jRP5ikJ4cDrfIxQRFeJWk6tOi5k2EA98OrSKNmxO7qye1vfAI5fYaTZHq7qAcdeQrr8nIk7dOr8Ing42J/l8jd7JWYH+Xp+pGHIIRrrZ7Q5OfOuNfEWU5gDuDkrxfAOvim2Oyn87fTlO/65s9RHARBoa1oqkZcCqS4Mb/h+GTOxaVu0eWw0vmC7edXsKO9uiyRQKfcYPaZia3mfru2N3ZLz7KRnLppj3IFaTQvVyogsCxQYF8jAFCzfbZeBm39oNaXu7MddHvvUsrRelseyl8Bd3QwVRFSGK26r+SDpHgeGfMyfzi2kQWyMiMedWuEMnWa0a8XJ4mz66JJQ9Y9iuKc4kcmyRW7GkJC+186bWexf9QbD6Ar/ZsFqmGuR1i1CRQ3T8g7FhfrWlqUbdNNXTo+zLQjURlg4LdJfMOc7Lpsf/x17DJJ+w8/OBoMSnAEsr67DO5onc+x2z0xlMGZCSyTl8jL6pc7d9Ed4lANjY6FbG0BZX8hLzF6U38QCvt0UZ+80iwWBetQ3IK9u3sL9h6SRpSu89xwai15qav6qDhWbI+NvHocTz4PzVhaPaFvVXQjSP8KT+Qh/obWpbqJzKD6fbROItQmo/Yl5laQL8tkWhwNqBwtohkR4YIk54CkZE6G6csVcX9ams2bfsFcPE8DjJZhYqFBp12g0pQeLQGGIPaXAfMGAKN2ce+pfH6o7TDJ7XDbDS0dpvnNqjnkaFKUTNVX7TC9st0F1oW90toXlqn1tATbs6hOvJI0rJzCnA1HodTcnPjke1TkBKkoDq80dikYggUwK6eQYL48+go+dTOdVgl9fayQJ7hHGTrjF24bf4PQCOgXFkdqT+ks0HF872B+TXcnn0cy6oy/fKFDcIpWtRY+I2p9SWH6k3gPzsZ+eZX6YFJDWfs5LEtuyKweG9LHK7KE9Si5lXQvVyogsCxQYF8jAFCzfbZcJ27oAY1tG/UIuCOwDMdcW8rOBNcRzBhe/rk5u3fETVO/QWvMbFMMkvIUB+AOQaN2MwJeh6GCjo3anWC6JV/Mu59JxZjF4v7tHGMOJGWNzqmMyjs8YwhsBeOejk+tvh/b6S5k6JN0Q8jimvYAopW8NXJ+91eomCTLfOdB4IOSGHCaNsTrJXKSa5WQzbNHPacSLQgBZNl5RN2TRH7mNLmNYZLB4dl3yA4wFNaJ5rdRKSefScWYxeL+7RxjDiRljc6rSbn1q2TnY9jQTu2mIxGi/z4d6nA6XpTsr3JKMy/94V+fScWYxeL+7RxjDiRljc6qHd3ouq9SfuspuEuZ/VA+rFOOO0lfL+bdd055gzhwXCeDdOIr1t6xHM/3pbDIkaVC1YoD572qcBtkaUhuNLlHPC9XKiCwLFBgXyMAULN9tl0y3hiMAMdKNHKg6iDd4TIGjIrMimFDodvXKQC/FvRnve+HWl9EUghc3TRh13EEz2vHPtDrvRnwntYyFQx9IyCoZ9ZM7fzU+bAhOgpT0tYfSq2h7CLo5IKcbRCwPilco93W74wCbTf3keeOYlMHRra874RbfQFmh7Cs4ui50sPr/pU+TRhnIVCmmYhMwsSvghQakDq/75ijCVM9jmwXVBFEHDANgQL/EKO5wUjNmgGSEjF8QEKlAhK/RivuYtFNLArTsGwsG5p3+Z9NaiC0d2TFw5SpJHo3E+DPxzDBKaiMeUdQKiYYMUq9T82M70q333w==";

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