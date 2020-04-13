package springpayroll.impl

class CtcGenrator
{

    public static Long employePfCalculation(long basicGet) {
        return  (Math.round(basicGet * 12.0 / 100));
    }

}
