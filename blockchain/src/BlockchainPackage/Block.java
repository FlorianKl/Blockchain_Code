package BlockchainPackage;
import java.util.ArrayList;
import java.util.Date;

public class Block {

    //Auflistung aller Attribute
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    //Block Konstruktor
    public Block(String data) {
        this.data = data;
        if (Block.blockchain.size() == 0) {
            this.previousHash = "0";
        }
        else {
            //Hier wird der vorherige Hash Wert übernommen
            this.previousHash = Block.blockchain.get(Block.blockchain.size() - 1).hash;
        }

        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }


    //Kalkulieren des Hash Wertes
    public String calculateHash() {
        String calculatehash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatehash;
    }

    //Minen des Blockes, mit berücksichtigung der Schwierigkeit
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring(0,difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Minen erfolgreich: " + hash);
    }

    //Kontrolle der Kette
    public static void isChainValid() {
        Block currentBlock;
        Block previousBlock;
        boolean fehler = true;

        System.out.println("\nÜberprüfe die Kette ...");

        //Alle Elemente der Kette werden einmal durchgegangenn und geprüft
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //Fehler entsteht, wenn der eingetragene Hash nicht mit dem, der durch die Methode errechnet wird, überreinstimmt
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("\nFehler in der Kette, bei dem Block "+(i+1)+" liegt ein Fehler am akteullen Hashwert vor");
                fehler = false;
            }
            //Fehler entsteht, wenn der vorherige Hash Wert nicht mit mit dem aktuellen übereinstimmt
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("\nFehler in der Kette, bei den Blöcken "+(i-1)+" und "+(i)+" lieget ein Fehler mit dem aktuellen und vorherigen Hashwert vor ");
                fehler = false;
            }
        }
    if (fehler) {
        System.out.println("\nKein Fehler aufgetreten. Kette ist vollständig");
    }
    }

    public String getdata() {
        return data;
    }

    public  void setData(String Data) {
        this.data = Data;
    }

}