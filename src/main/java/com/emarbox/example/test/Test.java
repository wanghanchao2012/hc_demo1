package com.emarbox.example.test;

import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class Test {
	static NumberFormat ddf1 = NumberFormat.getNumberInstance();

	public static void main(String[] args) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT h.uid, ");
		sql.append("       h.cid, ");
		sql.append("       h.last_modified_time, ");
		sql.append("       'AD_STATUS_NORMAL'  status, ");
		sql.append("       Date(h.create_time) create_time ");
		sql.append("FROM   gdt_campaign_history h ");
		sql.append("       INNER JOIN gdt_campaign c ON h.cid = c.cid ");
		sql.append("       INNER JOIN social_campaign sc ON sc.platform_id = c.cid ");
		sql.append("WHERE  ( c.delete_on_gdt = 1 OR c.delete_on_gdt IS NULL ) ");
		sql.append("       AND h.uid IN (:uidList) ");
		sql.append("       and ( h.last_modified_time > unix_timestamp(date_sub(now(), interval 30 day)) or c.last_modified_time > unix_timestamp(date_sub(now(), interval 30 day) ) ) ");
		sql.append("GROUP  BY h.uid, h.cid ");
		sql.append("UNION ");
		sql.append("SELECT h.uid, ");
		sql.append("       h.cid, ");
		sql.append("       h.last_modified_time, ");
		sql.append("       'AD_STATUS_NORMAL'  status, ");
		sql.append("       Date(h.create_time) create_time ");
		sql.append("FROM   gdt_campaign_history h ");
		sql.append("       INNER JOIN gdt_campaign c  ON h.cid = c.cid ");
		sql.append("       INNER JOIN social_campaign sc  ON sc.platform_id = c.cid ");
		sql.append("WHERE  ( c.delete_on_gdt = 1 OR c.delete_on_gdt IS NULL ) ");
		sql.append("       AND h.uid IN (:uidList) ");
		sql.append("       AND ( h.status = 'AD_STATUS_NORMAL'  and ( h.create_time between date_format(date_add(curdate(),interval 1-dayofmonth(curdate()) day),'%y-%m-%d 00:00:00') and date_format(last_day(curdate()),'%y-%m-%d 23:59:59' ) ) ) ");
		sql.append("GROUP  BY h.uid,h.cid");
		System.out.println(sql);
	}

}
