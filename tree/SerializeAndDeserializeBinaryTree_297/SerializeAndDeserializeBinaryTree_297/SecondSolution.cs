using SymmetricTree_101;

namespace SerializeAndDeserializeBinaryTree_297
{
  public class SecondSolution
  {
    public string serialize(TreeNode root)
    {
      if (root == null) return "null";

      return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(string data)
    {
      if (string.IsNullOrEmpty(data)) return null;

      var fields = data.Split(',');
      var i = 0;

      var root = deserialize(fields, ref i);

      return root;
    }

    public TreeNode deserialize(string[] data, ref int i)
    {
      if (data[i] == "null")
      {
        i++;
        return null;
      }

      var root = new TreeNode(int.Parse(data[i++]));

      if (i < data.Length)
      {
        var left = deserialize(data, ref i);
        root.left = left;
      }

      if (i >= data.Length) return root;

      var right = deserialize(data, ref i);
      root.right = right;

      return root;
    }
  }
}