EAP_6=/Users/rfelix/redHat/consultoria/mprs-v2/chamado/POC/jboss-eap-6.4/standalone/deployments/
EAP_7=/Users/rfelix/redHat/consultoria/mprs-v2/chamado/POC/jboss-eap-7.2/standalone/deployments/

cp -v /Users/rfelix/redHat/consultoria/mprs-v2/chamado/POC/from-EAP-6.4-clean/ejbs/web/target/bpm-web.war $EAP_6
cp -v /Users/rfelix/redHat/consultoria/mprs-v2/chamado/POC/from-EAP-6.4-clean/web/app-web/target/sin-web.war $EAP_7
cp -v /Users/rfelix/redHat/consultoria/mprs-v2/chamado/POC/from-EAP-6.4-clean/web/ear/target/ear-6.4.0.GA.ear $EAP_7