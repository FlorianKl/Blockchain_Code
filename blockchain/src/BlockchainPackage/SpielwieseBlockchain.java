package BlockchainPackage;
import com.google.gson.GsonBuilder;

import javax.swing.*;

public class SpielwieseBlockchain {



    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog("Welche Aufgabe soll bearbeitet werden ?");
        int pointer = Integer.parseInt(input);

        input = JOptionPane.showInputDialog("Welcher Schwierigkeitsgard soll beim Minen berücksichtigt werden ?");
        int difficulty = Integer.parseInt(input);

        String VersuchedenBlockzuMinen = "Versuche den Block zu Minen ...";

        switch (pointer) {
            case 1: //Alles Normal
                Block.blockchain.add(new Block("Hallo, ich bin der erste Block"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(0).mineBlock(difficulty);

                Block.blockchain.add(new Block("Jetzt kommt Nummer zwei"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(1).mineBlock(difficulty);

                Block.blockchain.add(new Block("Das Beste kommt zum Schluss"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(2).mineBlock(difficulty);

                Block.isChainValid();

                System.out.println("\nAlle Blöcke nochmal: ");

                String blockchainJsoncase1 = new GsonBuilder().setPrettyPrinting().create().toJson(Block.blockchain);

                System.out.println(blockchainJsoncase1);
                break;

            case 2: //Versuch den aktuellen Hashwert zu ändern
                Block.blockchain.add(new Block("Hallo, ich bin der erste Block"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(0).mineBlock(difficulty);

                Block.blockchain.add(new Block("Jetzt kommt Nummer zwei"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(1).mineBlock(difficulty);

                Block.blockchain.add(new Block("Das Beste kommt zum Schluss"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(2).mineBlock(difficulty);

                Block.isChainValid();

                    System.out.println("\nDer Hashwert wird nun geändert!");

                    Block.blockchain.get(1).hash = "Veränderter Hashwert";

                    Block.isChainValid();

                System.out.println("\nAlle Blöcke nochmal: ");

                String blockchainJsoncase2 = new GsonBuilder().setPrettyPrinting().create().toJson(Block.blockchain);

                System.out.println(blockchainJsoncase2);

                break;

            case 3: //Versuche den aktuellen Hashwert und den vorherigen Hashwert zu ändern
                Block.blockchain.add(new Block("Hallo, ich bin der erste Block"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(0).mineBlock(difficulty);

                Block.blockchain.add(new Block("Jetzt kommt Nummer zwei"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(1).mineBlock(difficulty);

                Block.blockchain.add(new Block("Das Beste kommt zum Schluss"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(2).mineBlock(difficulty);

                Block.isChainValid();

                    System.out.println("\nDer Hashwert wird nun geändert!");

                    Block.blockchain.get(1).hash = "Veränderter Hashwert";

                    System.out.println("\nNun wird auch der vorherige Hashwert geändert!");

                    Block.blockchain.get(2).previousHash = "Veränderter Hashwert";

                Block.isChainValid();

                System.out.println("\nAlle Blöcke nochmal: ");

                String blockchainJsoncase3 = new GsonBuilder().setPrettyPrinting().create().toJson(Block.blockchain);

                System.out.println(blockchainJsoncase3);
                break;

            case 4: //Änderung der Data
                Block.blockchain.add(new Block("A überweißt an B 5 \u20BF"+"\nB überweißt an C 2 \u20BF"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(0).mineBlock(difficulty);

                Block.blockchain.add(new Block("C überweißt an A 1 \u20BF"+"\nA überweißt an B 3 \u20BF"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(1).mineBlock(difficulty);

                Block.blockchain.add(new Block("B überweißt an A 5 \u20BF"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(2).mineBlock(difficulty);

                Block.isChainValid();

                    System.out.println("\nHacker greift an !!!!!!");

                    Block.blockchain.get(1).setData("C überweißt an A 1\u20BF\nA überweißt an Hacker 50 \u20BF");

                Block.isChainValid();

                System.out.println("\nAlle Blöcke nochmal: ");

                String blockchainJsoncase4 = new GsonBuilder().setPrettyPrinting().create().toJson(Block.blockchain);

                System.out.println(blockchainJsoncase4);
                break;

            case 5: //Wiederherstellung der Blockchainkette
                Block.blockchain.add(new Block("A überweißt an B 5 \u20BF"+"\nB überweißt an C 2 \u20BF"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(0).mineBlock(difficulty);

                Block.blockchain.add(new Block("C überweißt an A 1 \u20BF"+"\nA überweißt an B 3 \u20BF"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(1).mineBlock(difficulty);

                Block.blockchain.add(new Block("B überweißt an A 5 \u20BF"));
                System.out.println(VersuchedenBlockzuMinen);
                Block.blockchain.get(2).mineBlock(difficulty);

                Block.isChainValid();

                System.out.println("\nHacker greift an !!!!!!");

                Block.blockchain.get(1).setData("C überweißt an A 1\u20BF"+"\nA überweißt an Hacker 50 \u20BF");

                Block.isChainValid();

                    System.out.println("\nDie Daten werden wieder hergestellt");

                    Block.blockchain.get(1).setData("C überweißt an A 1 \u20BF"+"\nA überweißt an B 3 \u20BF");

                    Block.isChainValid();

                System.out.println("\nAlle Blöcke nochmal: ");

                String blockchainJsoncase5 = new GsonBuilder().setPrettyPrinting().create().toJson(Block.blockchain);

                System.out.println(blockchainJsoncase5);
                break;

            default:


        }




    }
}
