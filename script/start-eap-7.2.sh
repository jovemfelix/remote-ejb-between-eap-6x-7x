THIS_SCRIPT=$(basename -- "$0")
echo Running $THIS_SCRIPT
WORKDIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)

# optional - you can change to reflect your enviroment or use existing variable
# export JBOSS_HOME=${WORKDIR}/jboss-eap-7.2

if [ -z ${JBOSS_HOME+x} ]; then 
    echo "JBOSS_HOME is unset"; 
else
    echo "JBOSS_HOME is set to '$JBOSS_HOME'"
    sh ${WORKDIR}/clean-workdir-eap.sh
    sh ${JBOSS_HOME}/bin/standalone.sh  -Djboss.node.name='EAP-7'  -Djboss.socket.binding.port-offset=200
fi
