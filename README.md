# Universal Wiki Converter readme.txt file

To build the UWC use ANT (http://ant.apache.org/):
* cd devel (the devel dir.)
* ant      (the default target will build the UWC under 

Note: you do not need to build the UWC to run it; only if you're doing development work with it. 

To run the newly built UWC
* cd target/uwc/
* chmod a+x *sh
* ./run_uwc_devel.sh

## using Maven

```shell
mvn install:install-file -DgroupId=com.atlassian.confluence \
                           -DartifactId=confluence-xmlrpc \
                           -Dversion=5.2.0 \
                           -Dfile=lib/confluence-xmlrpc-wrapper-v5.2.0.jar \
                           -Dpackaging=jar
mvn install:install-file -DgroupId=net.antonioshome.swing \
                           -DartifactId=treewrapper \
                           -Dversion=1.1.1.1 \
                           -Dfile=lib/treewrapper.jar \
                           -Dpackaging=jar
mvn install:install-file -DgroupId=org.jvnet.substance \
                           -DartifactId=substance \
                           -Dversion=2.3final \
                           -Dfile=lib/substance.jar \
                           -Dpackaging=jar

```

## Notes

Use the UI build using ANT and run it using `./run_uwc_on_mac.sh ` from within the `target/uwc` folder. 
Make sure to copy the `converter.twiki.properties` file to `conf` under the output folder as well as the `confluenceSettings.properties` file.

### Cleaning script for unused TWiki pages

```
# Delete Twiki fluff
find data/ -name "WebAtom.*" -type f -delete
find data/ -name "WebChanges.*" -type f -delete
find data/ -name "WebIndex.*" -type f -delete
find data/ -name "WebLeftBar.*" -type f -delete
find data/ -name "WebNotify.*" -type f -delete
find data/ -name "WebPreferences.*" -type f -delete
find data/ -name "WebSearch.*" -type f -delete
find data/ -name "WebStatistics.*" -type f -delete
find data/ -name "WebTopicCreator.*" -type f -delete
find data/ -name "WebTopicList.*" -type f -delete
find data/ -name "WebRss.*" -type f -delete
find data/ -name "WebAtomBase.*" -type f -delete
find data/ -name "WebLeftBar*" -type f -delete
find data/ -name "WebTopBar.*" -type f -delete
find data/ -name "WebSiteTools.*" -type f -delete
find data/ -name "WebSearchAdvanced.*" -type f -delete
find data/ -name "WebRssBase.*" -type f -delete
find data/ -name "WebTopicViewTemplate.*" -type f -delete
find data/ -name "WebBottomBar.*" -type f -delete
find data/ -name "WebTopicNonWikiTemplate.*" -type f -delete
find data/ -name "WebTopicEditTemplate.*" -type f -delete
find data/ -name "WebPreferencesHelp.*" -type f -delete
find data/ -name "WebChangesAlert.*" -type f -delete
find data/ -name "WebTemplateTopics.*" -type f -delete
```


### Consolidate several Webs into the same Confluence space

In case several TWiki webs need to go into the same Confluence space and page names collide, all pages can be prefixed

```
LC_ALL=C sed -i "" 's/%META:TOPICPARENT{name="/%META:TOPICPARENT{name="BKV2_/' *.txt
```
and renamed
```
for f in * ; do mv -- "$f" "BKV2_$f" ; done  
```

In this case you also need to rename the attachment folders. Note that this will break TWiki-links in the exported Web.

### Common sources of failed page transfers

- "Generate PDF" script tags and PDFSTART/PDFSTOP tags (can be added to converter settings for replacement)
- Code blocks with { and } (only found in <verbatim>-tags for DB2 scripts)
- Windows file paths containing "\"
- Styles/CSS in <verbatim> tags


## More

More details and documentation is here: https://migrations.atlassian.net/wiki/display/UWC/Universal+Wiki+Converter

# ABOUT THE UWC

This code is open source and is up to date with Atlassian's latest storage format of Atlassian Confluence
(introduced in Confluence 4). We successfully use/run the UWC for Confluence 5.X releases, however, there are *many* flavors and versions of MIGRATE_FROM wikis. 

As such, we feel it is accurate to say that this is "a tool", yet not always the end-to-end solution or silver bullet. Wiki formats are varied, and so please understand that the UWC will get you further along, but there may be post-processing, additional scripting, username database merging, or other things required to assist in the process. 

Please refer to the Wiki Migration Checklist (http://www.appfusions.com/display/Dashboard/Wiki+Migration+Checklist) to educate yourself on what is invoived in a migration. The checklist is not to suggest that all content elements are problematic. They aren't. But some are, and not always the same between different flavors of wikis that are being migrated from.

We do provide paid ongoing small and big support for migrations, depending on needs. Email us at info@appfusions.com and let us know what you are trying to do and we can see if we can help you!  We have many client references too.

