package com.xiamen.www.myapplication3.kotlin.utils


import java.security.MessageDigest


/**
 * Created by White on 2018/3/8.
 */
class Md5Util {
    companion object {
        fun toMD5(sourceStr: String): String {
            var result = ""
            try {
                val md = MessageDigest.getInstance("MD5")
                md.update(sourceStr.toByte())
                val b = md.digest()
                var i: Int
                val buf = StringBuilder("")
                for (aB in b) {
                    i = aB.toInt()
                    if (i < 0) {
                        i += 256
                    }
                    if (i < 16) {
                        buf.append("0")
                    }
                    buf.append(Integer.toHexString(i))
                    result = buf.toString()
                }
            } catch (e: Exception) {
                println(e)
            }
            return result
        }
    }

}




