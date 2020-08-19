#! /bin/bash
mvn clean verify -DENV=qa -Dwebdriver.driver=chrome
test_status=$?
echo "Test Status: $test_status"
exit $test_status


