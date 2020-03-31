if [ -z ${JBOSS_HOME+x} ]; then 
    echo "[add] JBOSS_HOME is unset"; 
else
    echo "[add] JBOSS_HOME is set to '$JBOSS_HOME'"
    echo "adding ejb user to '$JBOSS_HOME'"

    sh $JBOSS_HOME/bin/add-user.sh -a -u ejb -p redhat@123
fi