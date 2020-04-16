if [ -z ${JBOSS_HOME+x} ]; then 
    echo "[clean] JBOSS_HOME is unset"; 
else
    echo "[clean] JBOSS_HOME is set to '$JBOSS_HOME'"

    rm -rf $JBOSS_HOME/standalone/log/*
    rm -rf $JBOSS_HOME/standalone/tmp/*
    rm -rf $JBOSS_HOME/standalone/deployments/*
    rm -rf $JBOSS_HOME/standalone/data/*
    rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/*
    sed -i "" '/<deployments>/,/<\/deployments>/d' $JBOSS_HOME/standalone/configuration/standalone.xml

    # clear the screen
    clear
fi