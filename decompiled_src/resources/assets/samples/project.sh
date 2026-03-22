#查看项目
CK () {
for i in $(ls -d $DNA_DIR/DNA_*);do
  echo "${i##*/}"
done
}
#新建项目
XJ () {
if [ -d $DNA_DIR/DNA_"$T" ]; then
  echo "> Project already exists and will be renamed automatically!"
  T="$T"-`date "+%Y%m%d%H%M%S"`
  echo "> Creating：DNA_${T}"
  mkdir -p $DNA_DIR/DNA_"$T"
else
  echo "> Creating：DNA_${T}"
  mkdir -p $DNA_DIR/DNA_"$T"
fi
echo "> Created!"
echo "DNA_${T}" > $TMPDIR/DNA.ini
}
#删除项目
SC () {
for i in ${TSS};do
  echo "> Deleting：${i}"
  rm -rf $DNA_DIR/$i
  rm -rf $DNA_TMP/$i
  if [ "$i" = "$project" ];then
    rm -rf $TMPDIR/DNA.ini
  fi
  echo "> Deleted！"
done
}
#删除插件
sub (){
for i in ${sub};do
  echo "> Deleting：$i"
  rm -rf $START_DIR/module/$i
  echo "> Deleted！"
done
}

$1