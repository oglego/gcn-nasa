# Scala Kafka Consumer for GCN Classic Swift Actual Pointing Direction

## Overview
This Scala application is a Kafka consumer that connects to the **gcn.nasa.gov** Kafka cluster and subscribes to the **gcn.classic.text.swift_actual_pointdir** topic. The topic provides real-time updates on the actual pointing direction of the Swift space telescope, which is used for detecting and studying gamma-ray bursts (GRBs).

## What is GCN Classic?
The **Gamma-ray Coordinates Network (GCN)** is a system that distributes real-time information about high-energy astrophysical events. The **GCN Classic** system provides alerts via various formats, including Kafka, to facilitate automated and rapid responses by observatories and researchers worldwide.

## About `gcn.classic.text.swift_actual_pointdir`
This Kafka topic delivers updates on the actual pointing direction of NASA's Swift telescope. The Swift mission specializes in detecting and analyzing gamma-ray bursts, and this data is crucial for tracking transient astrophysical events.

## Prerequisites
Before running the Scala application, ensure you have the following:
- **Scala 3.3+** installed
- **Apache Kafka Client for Scala** (such as `org.apache.kafka:kafka-clients`)
- **Access to the NASA Kafka cluster** (`gcn.nasa.gov`)
- **A valid authentication mechanism** (SASL SSL)

## Installation
Clone this repository:
```sh
git clone https://github.com/oglego/gcn-nasa.git
cd gcn-nasa
```

## Compile with Scala
```
sbt clean compile assembly
```

## Running with Docker
```
docker build -t gcn-nasa .
```

Make sure that the Docker daemon is running - once this is complete then you can run a new container and see the
applications output.

## Expected Output

2025-02-28 05:15:51 Consumed: TITLE:           GCN/SWIFT NOTICE

2025-02-28 05:15:51 NOTICE_DATE:     Fri 28 Feb 25 04:18:55 UT

2025-02-28 05:15:51 NOTICE_TYPE:     SWIFT Actual Pointing Direction

2025-02-28 05:15:51 CURR_POINT_RA:    81.630d {+05h 26m 31s} (J2000)

2025-02-28 05:15:51 CURR_POINT_DEC:  -17.917d {-17d 55' 01"} (J2000)

2025-02-28 05:15:51 CURR_POINT_ROLL: 262.511d

2025-02-28 05:15:51 SLEW_TIME:       15528.53 SOD {04:18:48.53} UT

2025-02-28 05:15:51 SLEW_DATE:       20734 TJD;    59 DOY;   25/02/28

2025-02-28 05:15:51 TGT_NUM:         16870,   Seg_Num: 29

2025-02-28 05:15:51 SUN_POSTN:       341.37d {+22h 45m 29s}   -7.88d {-07d 52' 55"}

2025-02-28 05:15:51 SUN_DIST:         97.48 [deg]   Sun_angle= -6.7 [hr] (East of Sun)

2025-02-28 05:15:51 MOON_POSTN:      343.84d {+22h 55m 22s}   -8.46d {-08d 27' 32"}

2025-02-28 05:15:51 MOON_DIST:        94.98 [deg]

2025-02-28 05:15:51 MOON_ILLUM:      0 [%]

2025-02-28 05:15:51 GAL_COORDS:      220.43,-26.55 [deg] galactic lon,lat of the pointing direction

2025-02-28 05:15:51 ECL_COORDS:       79.42,-41.05 [deg] ecliptic lon,lat of the pointing direction

2025-02-28 05:15:51 COMMENTS:        SWIFT has settled on a new target (pointing direction).  

2025-02-28 05:15:51 COMMENTS:        The SLEW_TIME field represents the end of the slew plus ~30 sec for the ground s/w to detect the slew_settled state.  

2025-02-28 05:15:51 COMMENTS:        Note that this is the actual pointing direction -- the result of PPST or a TOO.  

2025-02-28 05:15:51 COMMENTS:        The spacecraft longitude,latitude at Notice_time is 152.40,-18.77 [deg].  

2025-02-28 05:15:51  (Partition: 0, Offset: 99530)

## References

[Kafka Client Setup](https://gcn.nasa.gov/docs/client)

[Swift Mission](https://swift.gsfc.nasa.gov/about_swift/#:~:text=Its%20three%20instruments%20work%20together,and%20search%20for%20new%20types.)

[Apache Kafka](https://kafka.apache.org)

[Docker](https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://docs.docker.com/&ved=2ahUKEwjm_Py3wOWLAxXsvokEHU-TDaYQFnoECBcQAQ&usg=AOvVaw2o85KRImb73of1uit3agPQ)

