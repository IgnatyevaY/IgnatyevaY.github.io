package com.mycompany.app;

import com.kennycason.kumo.nlp.FrequencyFileLoader;
import java.io.IOException;
import java.io.File;
import java.util.List;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import java.awt.Dimension;
import java.awt.Color;

public class App 
{
    public static void main( String[] args )throws IOException
    {
        final FrequencyFileLoader frequencyFileLoader = new FrequencyFileLoader();
        final List<WordFrequency> wordFrequencies = frequencyFileLoader.load(new File("input.txt"));
        final Dimension dimension = new Dimension(510,346);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new PixelBoundryBackground("wolf.png"));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
        wordCloud.setFontScalar(new LinearFontScalar(4, 85));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("wolf_wordcloud.png");
    }
}
