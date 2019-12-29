package me.geed.util;

import java.util.ArrayList;
import java.util.List;

import me.geed.models.Question;

public  class QuestionInitializer {
    private static int counter = 0;
    private static List<Question> questions;

    public static  void initializeQuestions(){
        questions = new ArrayList<Question>();

        questions.add(new Question("Açışal Momentum","L = m.v.r\n" +
                "L = m.ω.r2\n" +
                "L = I.ω\n","L = r.P\n" +
                "L = m.v.r\n" +
                "L = m.ω.r2\n" +
                "L = I.ω\n" +
                "Açısal momentumun yönü sağ el kuralıyla bulunmaktadır. Fizikte manyetizma konusunda da sağ el kuralını kullanmaktayız.\n" +
                "\n" +
                "Sağ elimizi kullanarak açısal momentumun yönünü bulabiliriz. Dört parmağımızın yönü dönme yönünü gösterdiği zaman baş parmağımızın ucu açısal momentum vektörünün yönünü gösterir.Açısal momentumun mantığını anlamak açısından da yönünü bilmek önemlidir. Örneğin sağdan sola doğru yerde dönen bir cisim yere bir momentum uygular. Bunun aklınıza oturması için vidayı çevirdiğinizde tahtada ilerlemesi olarak da düşünebilirsiniz.\n" +
                "\n" +
                "Açısal momentumun mantığının iyi anlaşılması için farklı türlerde bol miktarda soru çözmek gerekir. Gezegenlerin dönme davranışını anlamak için de açılsa momentumu iyi bilmek gerekir.\n" +
                "Açısal Momentum Korunumu\n" +
                "Açısal momentum korunumu ilkesi atomik düzeyden gezegenler düzeyine kadar her türlü çembersel hareketi anlamak açısından önemlidir. Bu ilk evrenin her kademesinde geçerlidir.\n" +
                "\n" +
                "Bir sisteme dışarıdan bir kuvvet etki etmiyorsa sistemin açısal momentumu sabit kalır. Buna açısal momentumun korunumu yasası denir.\n" +
                "Sisteme etki yoksa aynı zamanda çizgisel momentumun da korunduğunu biliyoruz.\n" +
                "\n" +
                "Bunu bir örnek üzerinden açıklayalım. Güneş sisteminde yörüngesinde dönen bir cisim güneşe yaklaştığı zaman yörünge yarıçapı küçülür. L = m.v.r bağıntısına göre açısal momentumun sabit kalması için r küçüldüğünde m.v'nin büyümesi gerekir. Ancak kütle sabit olduğundan v yani çizgisel hız artar. Biz bunu Güneş'e yaklaşan gezegenin çizgisel hızı artar şeklinde kural olarak öğrenmekteyiz."));
        questions.add(new Question("Newton Birinci Yasası"," Newton’un 1. Yasası: Dengelenmiş kuvvetlerin etkisindeki bir parçacık ya durur ya da bir doğru boyunca sabit hızla hareket eder. "," Newton’un 1. Yasası: Dengelenmiş kuvvetlerin etkisindeki bir parçacık ya durur ya da bir doğru boyunca sabit hızla hareket eder. "));
        questions.add(new Question("Newton İkinci Yasası","Dengelenmemiş bir F kuvvetinin bir parçacığa\n" +
                "etkimesi durumunda, parçacıkta oluşacak a ivmesi, kuvvetle aynı\n" +
                "yönde olurken, şiddeti de kuvvetle doğru orantılıdır. ","Dengelenmemiş bir F kuvvetinin bir parçacığa\n" +
                "etkimesi durumunda, parçacıkta oluşacak a ivmesi, kuvvetle aynı\n" +
                "yönde olurken, şiddeti de kuvvetle doğru orantılıdır. "));
        questions.add(new Question("Newton Üçüncü Yasası","İki parçacık arasında etki\uF02Dtepki biçimindeki\n" +
                "karşılıklı iki kuvvetin doğrultuları aynı, şiddetleri eşit ama yönleri\n" +
                "zıttır. ","İki parçacık arasında etki\uF02Dtepki biçimindeki\n" +
                "karşılıklı iki kuvvetin doğrultuları aynı, şiddetleri eşit ama yönleri\n" +
                "zıttır. "));
        questions.add(new Question("Silindirik Kordinatlar","F eee = ++ \uF053(FF F rr zz \uF071 \uF071 )","Uzayda konum vektörü bu iki takımdan birine uygun ifade edilebilirse,\n" +
                "daha sonra hareket denklemleri üstünden problemin kinetiği çözülebilir.\n" +
                "SİLİNDİRİK KOORDİNATLAR: Şekil 3.9 daki birim vektörlere göre hareket denklemi F a = m yı bileşenleri cinsinden yazarsak:\n" +
                "F eee = ++ \uF053(FF F rr zz \uF071 \uF071 )\n" +
                "r r\n" +
                "z z\n" +
                "F ma\n" +
                "F ma\n" +
                "F ma\n" +
                "\uF071 \uF071\n" +
                "\uF053\n" +
                "\uF053\n" +
                "\uF053\n" +
                "= ïü\n" +
                "ï\n" +
                "ï = ï\n" +
                "ý\n" +
                "ï\n" +
                "ï = ï\n" +
                "ïþ\n" +
                " (3.20)\n" +
                "İvme bileşenleri:\n" +
                "2\n" +
                "r a rr = - \uF071\n" +
                "\uF026 \uF026\uF026 (3.21)\n" +
                "ar r2 \uF071 = +\uF071 \uF071 \uF026\uF026 \uF026 \uF026 (3.22)\n" +
                "z a z = \uF026\uF026 "));
        questions.add(new Question("Küresel koordinat parametreleri kartezyen koordinatlar cinsinden","\n" +
                "\n" +
                "r=\\sqrt{x^2+y^2+z^2}\n" +
                "\n" +
                "\\theta=\\arctan(y/x)\n" +
                "\n" +
                "\\phi=\\arccos(z/r)",
                "\n" +
                "r=\\sqrt{x^2+y^2+z^2}\n" +
                "\n" +
                "\\theta=\\arctan(y/x)\n" +
                "\n" +
                "\\phi=\\arccos(z/r)"));


    }

    public static Question getCurrentQuestion(){
        return questions.get(counter);
    }

    public static Question getNextQuestion(){
        if(questions.size()-1 > counter ){
            counter++;
        }
        else{
            //list out of index error
        }
        return questions.get(counter);
    }

    public static Question getPreviousQuestion(){
        if(counter > 0 ){
            counter--;
        }
        else{
            //list out of index error
        }
        return questions.get(counter);
    }



}
