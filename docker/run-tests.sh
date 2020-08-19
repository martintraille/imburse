#! /bin/bash
mvn clean verify -DENV=qa
test_status=$?
echo "Test Status: $test_status"
exit $test_status


