package model;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;
    private int difficulty;

    public Blockchain(int difficulty) {
        this.difficulty = difficulty;
        this.chain = new ArrayList<>();
        // Creamos el bloque génesis
        Block genesis = new Block(0, "Bloque Génesis", "0");
        genesis.mineBlock(difficulty);
        chain.add(genesis);
    }

    public void addBlock(String data) {
        Block lastBlock = getLatestBlock();
        Block newBlock = new Block(lastBlock.getIndex() + 1, data, lastBlock.getHash());
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public List<Block> getChain() {
        return chain;
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);

            if (!current.getHash().equals(current.calculateHash())) {
                return false;
            }

            if (!current.getPreviousHash().equals(previous.getHash())) {
                return false;
            }
        }
        return true;
    }
}
