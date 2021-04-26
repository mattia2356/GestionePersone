import java.io.FileWriter;

public class Frequenza {

    GestionePersone gp = new GestionePersone();
    // attributi
    private int[] freqAlt = new int[9];
    private int[] freqPes = new int[7];
    private int[] frequenze;       //contiene le freq
    private double minClasseAltezza;//ampiezza minima altezza
    private double minClassePesi; //ampiezza minima pesi
    private int nClassi;           //numero di scaglioni (credo)
    private double ampiezzaClassi; //differenza tra classe e classe
    

    // costruttore default
    public Frequenza() {
        frequenze = new int[16];
        minClasseAltezza = 140;
        minClassePesi = 50;
        nClassi = 16;
        ampiezzaClassi = 10;
    }

    // costruttore master
    public Frequenza(int[] fAlt, int[] fPes) {

        for (int i = 0; i < fAlt.length; i++) {
            freqAlt[i] = fAlt[i];
        }
        for (int i = 0; i < fPes.length; i++) {
            freqAlt[i] = fAlt[i];
        }
    }

    // costruttore di copia
    public Frequenza(Frequenza f) {
        for (int i = 0; i < freqAlt.length; i++) {
            freqAlt[i] = f.getFreqAlt(i);
        }
        for (int i = 0; i < freqPes.length; i++) {
            freqPes[i] = f.getFreqPes(i);
        }
    }

    // getter e setter singole celle
    public void setFreqAlt(int i, int freq) {
        this.freqAlt[i] = freq;
    }

    public int getFreqAlt(int i) {
        return freqAlt[i];
    }

    public void setFreqPes(int i, int freq) {
        this.freqPes[i] = freq;
    }

    public int getFreqPes(int i) {
        return freqPes[i];
    }


     //calcolo frequenze (compito)
    public void computaFreq(GestionePersone gp){

        //no deep copy [non serve]
        double[] altezze = gp.getAltezza();
        double[] pesi    = gp.getPeso();

        double ampiezza = minClasseAltezza;

        //for per freq altezze
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < altezze.length; j++) { 

                if (altezze[j] <= ampiezza && altezze[j] > ampiezza - ampiezzaClassi){
                    frequenze[i]++;
                }
            }
            //Aggiornare varibile per altezza
            ampiezza += ampiezzaClassi;

        }
            //aggiornare varibiale per pesi
            ampiezza = minClassePesi;
        //for per pesi
        for (int i = 9; i < 16; i++) {
            for (int j = 0; j < pesi.length; j++) {
                if(pesi[j]<=ampiezza && pesi[j] > ampiezza - ampiezzaClassi){
                    frequenze[i]++;
                }
            }
            ampiezza+=ampiezzaClassi;
        }

    }
    

    //save vecchia
    public void saveold(String nomeFile) throws Exception {

        FileWriter fw = new FileWriter(nomeFile);

        //salvataggio freq alt
        for (int i = 0; i < freqAlt.length; i++) {
            fw.write(getFreqAlt(i)+"; ");
        }

        //salvataggio freq pes
        for (int i = 0; i < freqPes.length; i++) {
            fw.write(getFreqPes(i)+"; ");
        }

        fw.close();
    }

    //save nuova
    public void save(String nomeFile) throws Exception{
        FileWriter fw = new FileWriter(nomeFile);
        double ampiezza = minClasseAltezza;

        for (int i = 0; i < 9; i++) {
            fw.write(ampiezza+"; ");
            fw.write(frequenze[i]);
            ampiezza += ampiezzaClassi;
        }
        ampiezza=minClassePesi;
        for (int i = 9; i < 16; i++) {
            fw.write(ampiezza+"; ");
            fw.write(frequenze[i]);
            ampiezza=ampiezzaClassi;
        }
        fw.close();
    }

//to String
public String toString(){
    String s = "";
    double ampiezza = minClasseAltezza;

    s += "Frequenze altezze:\n";
    for (int i = 0; i < 9; i++) {
        s += ampiezza+": "+frequenze[i]+"\n";
        ampiezza += ampiezzaClassi;
    }
    ampiezza = minClassePesi;
    s += "Frequenze pesi:\n";
    for (int i = 9; i<16; i++){
        s += ampiezza+": "+frequenze[i]+"\n";
        ampiezza += ampiezzaClassi;
    }

    return s;
}

}
