public class TestPattern {
    Integer total_two_th = 0;
    Integer total_five_hun = 16;
    Integer total_one_hun = 20;

    Integer twoThou = 0;
    Integer fiveHun = 0;
    Integer oneHun = 0;

    public Integer getTwoThousendRs(Integer amount){
        twoThou = twoThou+1;
        total_two_th = total_two_th-1;
        return amount-2000;
    }

    public Integer getFiveHunRs(Integer amount){
        fiveHun = fiveHun+1;
        total_five_hun = total_five_hun-1;
        return amount-500;
    }

    public Integer getOneHundRs(Integer amount){
        oneHun = oneHun+1;
        total_one_hun = total_one_hun-1;
        return amount-100;
    }

    public void extractMoney(Integer amount){

        boolean errAmount = false;

        if(amount%100==0) {
            while (amount>0){
               // System.out.println(amount);
                if(!(total_two_th>0)&&!(total_five_hun>0)&&!(total_one_hun>0)){
                    System.out.println("Out Of Cash");
                    errAmount = true;
                    break;
                }else
                    if(!(total_five_hun>0)&&!(total_one_hun>0)){
                        if(amount%2000==0)
                            amount = getTwoThousendRs(amount);
                        else {
                            System.out.println("500 and 100 not available Enter amount multiple of two thousand");
                            errAmount = true;
                            break;
                        }
                    }else
                        if(!(total_two_th>0) && !(total_one_hun>0)){
                            if(amount%500==0){
                                amount = getFiveHunRs(amount);
                            }else {
                                System.out.println("only 500 rs available put amount in mul of 500");
                                errAmount = true;
                                break;
                            }
                        }else
                            if(!(total_two_th>0) && !(total_five_hun>0)){
                                amount = getOneHundRs(amount);
                            }else
                                if(!(total_one_hun>0)){
                                if(amount%500==0){
                                    if(amount>2000){
                                        amount = getTwoThousendRs(amount);
                                    }else {
                                        amount = getFiveHunRs(amount);
                                    }
                                }else{
                                    System.out.println("100 not available Enter amount in 500 figure");
                                    errAmount = true;
                                    break;
                                }
                                }else
                                    if(!(total_five_hun>0)){
                                        if(amount>2000){
                                            amount = getTwoThousendRs(amount);
                                        }else {
                                            amount = getOneHundRs(amount);
                                        }
                                    }else
                                        if(!(total_two_th>0)){
                                            if(amount>500){
                                                amount = getFiveHunRs(amount);
                                            }else{
                                                amount = getOneHundRs(amount);
                                            }
                                        }else {
                                    if(amount>2000){
                                        amount = getTwoThousendRs(amount);
                                    }else {
                                        if(amount>500){
                                            amount = getFiveHunRs(amount);
                                        }else{
                                            amount = getOneHundRs(amount);
                                        }
                                    }
                                }
        }
            if(!errAmount) {
                System.out.println("2000Rs. " + twoThou + "  500Rs. " + fiveHun + "  100Rs. " + oneHun);
                System.out.println("Rest : 2000Rs. " + total_two_th + "  500Rs. " + total_five_hun + "  100Rs. " + total_one_hun);
            }
        }else{
            System.out.println("Amount Figure Is Not Proper put in multiple of 100,500 or 2000");
        }
    }
    public static void main(String[] args){
        TestPattern tp = new TestPattern();
        tp.extractMoney(3000);
    }
}
