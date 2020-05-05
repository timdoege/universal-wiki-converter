package com.atlassian.uwc.converters.twiki.cleaners;

public class HtmlTagRemove extends RegularExpressionCleaner
{
    /**
     * Remove HTML tags
     */
   public HtmlTagRemove()
   {
      super("(<|</)(.*?)(>)", "");
   }
}
