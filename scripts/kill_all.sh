#!/bin/bash

ps aux | grep geode | grep -v grep | awk '{ print $2 }' | xargs kill