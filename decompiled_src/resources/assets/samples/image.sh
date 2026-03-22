#本脚本由　by Han | 情非得已c，编写
#应用于搞机助手上
name(){
jian="$TEMP_DIR/by_name.log"
if [[ ! -f $jian ]]; then
        BLOCKDEV=`which blockdev`
        find /dev/block -mindepth 1 -type l | while read o; do
            [[ -d "$o" ]] && continue
            c=`basename "$o"`
            echo ${b[@]} | grep -q "$c" && continue
            echo $c
        done | sort -u | while read Row; do
            BLOCK=`find /dev/block -name $Row | head -n 1`
            if [[ $BLOCK == *uuid/* || $BLOCK == *mapper/com.* || $BLOCK == */sd* ]]; then continue; fi
            if [[ -n $BLOCKDEV ]]; then   
                size=`blockdev --getsize64 $BLOCK`
                if [[ $size -ge 1073741824 ]]; then
                    File_Type=`awk "BEGIN{print $size/1073741824}"`G
                elif [[ $size -ge 1048576 ]]; then
                    File_Type=`awk "BEGIN{print $size/1048576}"`MB
                elif [[ $size -ge 1024 ]]; then
                    File_Type=`awk "BEGIN{print $size/1024}"`kb
                elif [[ $size -le 1024 ]]; then
                    File_Type=${size}b
                fi
                    echo "$BLOCK|$Row 「大小：$File_Type」" >>$jian
            else
                echo "$BLOCK|$Row" >>$jian
            fi
        done
fi
cat $jian
}

extract(){
Extract=$DNA_DIR/image
IFS=$'\n'
[[ ! -d "$Extract" ]] && mkdir -p "$Extract"

for i in $IMG; do
    e=${i##*/}
    File="$Extract/${e}.img"
    if [[ ! -L $i ]];then
        echo "！$e partition not found and cannot be extracted"
    else
        echo "- Extracting the $e partition"
        dd if="$i" of="$File"
        echo "- Extracted $e partition to：$File"
    fi
done
}

flash(){
IFS=$'\n'
e=${IMG##*/}
echo "- Current selected partition: $e"
echo "- Flash file path：$Brush_in"
if [[ ! -L "$IMG" ]];then
    echo "！$e partition not found and cannot be flashed"
else
    if [[ -f "$Brush_in" ]]; then
        echo "- Flashing the $e partition"
        dd if="$Brush_in" of="$IMG"
        if [[ $CQ = 1 ]]; then
         echo "Restarting to recovery mode in……"
         for i in $(seq 4 -1 1); do
            echo $i
            sleep 1
         done
         reboot recovery
         fi
         if [[ $CQ1 = 1 ]]; then
          echo "Restarting system in……"
          for i in $(seq 4 -1 1); do
            echo $i
            sleep 1
          done
          reboot
         fi
    else
        echo "！$Brush_in Flash file not found and cannot be written to the $e partition"
    fi
    echo "- Finished"
    sleep 2
fi
}
$1