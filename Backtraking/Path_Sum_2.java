class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> outer = new ArrayList<>();
        recurse(outer, new ArrayList<>(), root, targetSum);
        return outer;
    }
    private void recurse(List<List<Integer>> outer, List<Integer> inner, TreeNode root, int targetSum){
        if(root == null)return;
        inner.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            outer.add(new ArrayList<>(inner)); // Add a copy of the current path
        }
        else{//if we dont get the value explore the left and right paths
        recurse(outer, inner, root.left, targetSum-root.val);
        recurse(outer, inner, root.right, targetSum-root.val);
        }
        //if im reaching this stage does this mean that this root and its  children were useless so we remove that value
        inner.remove(inner.size()-1);
    }
}
