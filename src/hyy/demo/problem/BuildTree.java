package hyy.demo.problem;

import hyy.demo.base.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *
 *输入:
 *  [1,2]
 *  [1,2]
 *  输出
 *  [1,null,2]
 * @author hyy
 * @version V2.0, 2020/1/15
 * @copyright
 */
public class BuildTree {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        for (int j = 0;j<inorder.length;j++){
            map.put(inorder[j],j);
        }
        return handle(preorder,0,inorder,0,inorder.length-1);
    }
    public TreeNode handle(int[] preorder,int pos,int[] inorder,int left,int right){
        if (left > right || pos == preorder.length){
            return null;
        }
        int index = map.get(preorder[pos]);
        TreeNode node = new TreeNode(preorder[pos]);
        node.left = handle(preorder,pos+1,inorder,left,index-1);
        node.right = handle(preorder,pos+index-left+1,inorder,index+1,right);
        return node;
    }
}
