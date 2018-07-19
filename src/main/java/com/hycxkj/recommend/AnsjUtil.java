package com.hycxkj.recommend;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Result;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 陈少平
 * @description  Ansj 分词工具类
 * @create in 2018/4/17 22:49
 */
public class AnsjUtil {

    /**
     *  期待的词性
     *  n: 名词
     *  nr : 人名
     *  ns : 地名
     *  nz : 其它专名
     *  nw : 新词
     *  nl : 名词性惯用语
     */
    private static final Set<String> expectedNature = new HashSet<String>() {{
        add("n");add("nr");add("ns");add("nz");add("nw");add("nl");
    }};

    /**
     *  关键词筛选的阈值。 小于这个值的一律筛选掉
     */
    private static final double KEY_WORD_THRESHOLD = 5.0;

    /**
     *  从字符串 s 中获取想要的单词
     * @param s
     * @return
     */
    public static List getWords(String s) {
        List<String> list = new ArrayList<>();
        Result result = ToAnalysis.parse(s);
        result.getTerms().forEach(x -> {
            if(expectedNature.contains(x.getNatureStr())) {
                list.add(x.getName());
            }
        });
        return list;
    }

    /**
     *  获取标题中 关键词阈值大于 5.0的 单词
     * @param title  作品标题
     * @return 阈值大于5.0的 KeyWord
     */
    public static List<Keyword> getWeightTop(String title) {
        List<Keyword> words = new ArrayList<>();
        KeyWordComputer<Analysis> keyword = new KeyWordComputer<>(10);
        keyword.setAnalysisType(new ToAnalysis());
        List<Keyword> list = keyword.computeArticleTfidf(title);
        list.forEach(x -> {
            if(x.getScore() > KEY_WORD_THRESHOLD){
                words.add(x);
            }
        });

        return words;
    }

}
