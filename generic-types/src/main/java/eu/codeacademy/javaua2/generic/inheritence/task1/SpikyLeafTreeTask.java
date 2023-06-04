package eu.codeacademy.javaua2.generic.inheritence.task1;

import java.util.Arrays;
import java.util.List;

public class SpikyLeafTreeTask {

    public static void forest(List<? extends Tree> treeList) {
        System.out.println("\nIvairus miskas:");
        treeList.stream()
                .map(Tree::get)
                .forEach(System.out::println);
    }

    public static void spikyForest(List<? extends SpikyTree> treeList) {
        System.out.println("\nSpygliuociu miskas:");
        treeList.stream()
                .map(SpikyTree::get)
                .forEach(System.out::println);
    }

    public static void birchForest(List<BirchTree> treeList) {
        System.out.println("\nBerzu miskas:");
        treeList.stream()
                .map(BirchTree::get)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Tree> ivairusMedziai = Arrays.asList(
                new BirchTree(),
                new OakTree(),
                new JuniperTree(),
                new SpruceTree(),
                new PineTree());
        forest(ivairusMedziai);

        List<SpikyTree> spygliuociaiMedziai = Arrays.asList(
                new JuniperTree(),
                new SpruceTree(),
                new PineTree());
        spikyForest(spygliuociaiMedziai);

        List<BirchTree> berzaiMedziai = Arrays.asList(
                new BirchTree(),
                new BirchTree(),
                new BirchTree());
        birchForest(berzaiMedziai);
    }
}
