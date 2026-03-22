#!/system/bin/sh

# 环境变量
export PATH="$({TOOLKIT}):$PATH"
export START_DIR="$({START_DIR})"
export TEMP_DIR="$({TEMP_DIR})"
export TMPDIR="$TEMP_DIR"
export APP_USER_ID="$({APP_USER_ID})"
# 判断是否有指定执行目录，跳转到起始目录
if [[ "$START_DIR" != "" ]] && [[ -d "$START_DIR" ]]
then
    cd "$START_DIR"
fi

# 工具目录
export DNA_DIR=$({SDCARD_PATH})/DNA
if [ ! -d $DNA_DIR ];then
   mkdir -p $DNA_DIR
fi
if [ "$({ROOT_PERMISSION})" = "true" ];then
  export DNA_TMP=/data/DNA
else
  export DNA_TMP=$({START_DIR})/DNA
fi
if [ -f $TMPDIR/DNA.ini ]; then
  project=$(cat $TMPDIR/DNA.ini)
  export DNA_PRO=$DNA_DIR/$project
  export DNA_DRO=$DNA_TMP/$project
fi
chown -R $APP_USER_ID:$APP_USER_ID $START_DIR
# 运行脚本
if [[ -f "$1" ]]; then
    chmod 755 "$1"
    source "$1"
else
    echo "${1} Lost" 1>&2
fi
exit 0