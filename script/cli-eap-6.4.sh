THIS_SCRIPT=$(basename -- "$0")
echo Running $THIS_SCRIPT
WORKDIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)
CLI_FILE=$1

# optional - you can change to reflect your enviroment or use existing variable
# export JBOSS_HOME=${WORKDIR}/jboss-eap-6.4

if [ -z ${JBOSS_HOME+x} ]; then
    echo "JBOSS_HOME is unset"; 
else
    echo "JBOSS_HOME is set to '$JBOSS_HOME'"

    if [ -z "${CLI_FILE}" ]; then
	    sh ${JBOSS_HOME}/bin/jboss-cli.sh -c --controller=localhost:10099
	else
        echo "CLI_FILE is set to '$CLI_FILE'"
    	sh ${JBOSS_HOME}/bin/jboss-cli.sh -c --controller=localhost:10099 --file=$CLI_FILE
	fi
fi
