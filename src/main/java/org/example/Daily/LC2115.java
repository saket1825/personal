package org.example.Daily;

import java.util.*;

public class LC2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> suppliesMap = new HashSet<>(Arrays.asList(supplies));
        HashSet<Integer> recipesMap = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        Set<String> ans = new HashSet<>();
        for(int i = 0;i< recipes.length;i++){
            String recipe = recipes[i];
            if(canBeMadeWithCurrentSupplies(i, recipes, suppliesMap, ingredients)){
                q.add(i);
            }else{
                recipesMap.add(i);
            }
        }

        while(!q.isEmpty()){
            int index = q.poll();
            ans.add(recipes[index]);
            suppliesMap.add(recipes[index]);
            recipesMap.remove(index);
            for(int indexR: recipesMap){
                if(canBeMadeWithCurrentSupplies(indexR, recipes, suppliesMap, ingredients)){
                    q.add(indexR);
                }
            }
        }
        return ans.stream().toList();
    }

    private boolean canBeMadeWithCurrentSupplies(int index, String[] recipe, HashSet<String> suppliesMap, List<List<String>> ingredients) {
        List<String> dishIngredient = ingredients.get(index);
        for (String check : dishIngredient) {
            if (!suppliesMap.contains(check)) {
                return false;
            }
        }
        return true;
    }
}
