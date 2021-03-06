/**
 * https://www.wiulus.com
 * <p>
 * 版权所有，侵权必究！
 */

package org.wiulus.spring.cloud.commons.tools.utils;


import org.wiulus.spring.cloud.commons.tools.validator.AssertUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 树形结构工具类，如：菜单、部门等
 *
 * @author : WiuLuS
 * @Version : 1.0
 */
public class TreeUtils {

    private TreeUtils() {
    }

    /**
     * 根据pid，构建树节点
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes, Long pid) {
        //pid不能为空
        AssertUtils.isNull(pid, "pid");

        List<T> treeList = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (pid.equals(treeNode.getPid())) {
                treeList.add(findChildren(treeNodes, treeNode));
            }
        }

        return treeList;
    }

    /**
     * 查找子节点
     */
    private static <T extends TreeNode> T findChildren(List<T> treeNodes, T rootNode) {
        for (T treeNode : treeNodes) {
            if (rootNode.getId().equals(treeNode.getPid())) {
                T children = findChildren(treeNodes, treeNode);
                if (rootNode.getChildren() == null && children != null) {
                    rootNode.setChildren(new ArrayList());
                } else if (children == null) {
                    continue;
                }
                rootNode.getChildren().add(children);
            }
        }
        return rootNode;
    }

    /**
     * 构建树节点
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes) {
        List<T> result = new ArrayList<>();

        //list转map
        Map<Long, T> nodeMap = new LinkedHashMap<>(treeNodes.size());
        for (T treeNode : treeNodes) {
            nodeMap.put(treeNode.getId(), treeNode);
        }

        for (T node : nodeMap.values()) {
            T parent = nodeMap.get(node.getPid());
            if (parent != null && !(node.getId().equals(parent.getId()))) {

                if( parent.getChildren()==null){
                    parent.setChildren(new ArrayList());
                }
                parent.getChildren().add(node);
                continue;
            }

            result.add(node);
        }

        return result;
    }

}