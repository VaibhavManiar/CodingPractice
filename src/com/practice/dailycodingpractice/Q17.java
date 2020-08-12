package com.practice.dailycodingpractice;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This problem was asked by Google.
 *
 * Suppose we represent our file system by a string in the following manner:
 *
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 *
 * dir
 *     subdir1
 *     subdir2
 *         file.ext
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 *
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
 *
 * dir
 *     subdir1
 *         file1.ext
 *         subsubdir1
 *     subdir2
 *         subsubdir2
 *             file2.ext
 *
 *
 *
 * dir
 * subdir1
 * \tfile1.ext
 * \tsubsubdir1
 * subdir2
 * \tsubsubdir2
 * \t\tfile2.ext
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 *
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 *
 * Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.
 *
 * Note:
 *
 * The name of a file contains at least a period and an extension.
 *
 * The name of a directory or sub-directory will not contain a period.
 */
public class Q17 {

    public static int findLongestPathSize(String dirPath) {
        String str = dirPath.replaceAll("\\n", "");
        String rootDir = str.split("\\t", 2)[0];
        str = str.replaceFirst(rootDir, "").replaceFirst("\\t", "");
        String[] dirs = str.split("\\t");
        int size = (int) Arrays.stream(dirs).filter(dir -> !dir.isEmpty()).count();

        List<List<String>> matrix = new ArrayList<>(size);
        for(int index = 0; index < size; index++) {
            matrix.add(new ArrayList<>());
        }

        matrix.get(0).add(rootDir);
        int count = 1;

        for(String dir : dirs) {
            if(dir.isEmpty()) {
                count++;
            } else {
                matrix.get(count).add(dir);
                count = 1;
            }
        }
        int finalSize = 0;
        for(List<String> list : matrix) {
            int currSize = list.stream().map(String::length).max(Integer::compareTo).orElse(0);
            finalSize += currSize;
        }

        return finalSize;
    }

    public static void main(String[] args) {
        findLongestPathSize("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
    }

}
