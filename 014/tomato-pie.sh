#!/bin/bash

ifdefault=0

while getopts ":d" opt
do
    work=1500
    wcopy=1500

    spause=300
    scopy=300

    bpause=900
    bcopy=900

    number=4
    backupnumber=4

    ifdefault=1
done

if [ $ifdefault -eq 0 ]
then
    read -p "Insert work time (minutes): " work
    ((wcopy=$work))
    read -p "Insert small pause time (minutes): " spause
    ((scopy=$spause))
    read -p "Insert big pause time (minutes): " bpause
    ((bcopy=$bpause))
    read -p "Insert number of small breaks: " number
    ((backupnumber=$number))
fi

while [ $backupnumber -ne 0 ]
do
    while [ $number -ne 0 ]
    do
        echo "Work time!                "

        while [ $work -gt 0 ]
        do
            echo -ne "$(($work%3600/60)) minutes $(($work%60)) seconds\033[0K\r"
            sleep 1
            ((work=$work-1))
        done
        ((number=$number-1))

        echo "Take a slice of pie!                  "

        while [ $spause -gt 0 ]
        do
            echo -ne "$(($spause%3600/60)) minutes $(($spause%60)) seconds\033[0K\r"
            sleep 1
            ((spause=$spause-1))
        done
        ((work=$wcopy))
        ((spause=$scopy))
    done

    echo "Work time!                    "

    while [ $work -gt 0 ]
    do
        echo -ne "$(($work%3600/60)) minutes $(($work%60)) seconds\033[0K\r"
        sleep 1
        ((work=$work-1))
    done

    echo "Take an entire pie now!                   "

    while [ $bpause -gt 0 ]
    do
        echo -ne "$(($bpause%3600/60)) minutes $(($bpause%60)) seconds\033[0K\r"
        sleep 1
        ((bpause=$bpause-1))
    done

    read -p "Do you want to go again? [y/n] " cond
    if [ "$cond" = "y" ] || [ "$cond" = "Y" ]
    then
        ((number=$backupnumber))
        ((work=$wcopy))
        ((spause=$scopy))
        ((bpause=$bcopy))
    elif [ "$cond" = "n" ] || [ "$cond" = "N" ]
    then
        exit 0
    fi
done
