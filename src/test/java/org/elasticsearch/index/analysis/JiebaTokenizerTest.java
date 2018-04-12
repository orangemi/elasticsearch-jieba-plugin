package org.elasticsearch.index.analysis;

import com.huaban.analysis.jieba.JiebaSegmenter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.junit.Assert;
import java.io.StringReader;
import org.junit.Test;

import java.io.IOException;

public class JiebaTokenizerTest {
  @Test
  public void tokenizerTest() {
    String message = "中华人民共和国";

    JiebaTokenizer tokenizer = new JiebaTokenizer("INDEX");
    tokenizer.setReader(new StringReader(message));
    int lastStartOffset = 0;
    try {
      tokenizer.reset();

      while (true) {
        boolean hasNext = tokenizer.incrementToken();
        if (!hasNext) break;
        CharTermAttribute term = tokenizer.getAttribute(CharTermAttribute.class);
        OffsetAttribute offset = tokenizer.getAttribute(OffsetAttribute.class);
        Assert.assertTrue(offset.startOffset() >= lastStartOffset);
        lastStartOffset = offset.startOffset();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
