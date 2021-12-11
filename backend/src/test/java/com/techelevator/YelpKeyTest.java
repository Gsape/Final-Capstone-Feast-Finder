package com.techelevator;

import com.techelevator.dao.FinalCapstoneDaoTests;
import com.techelevator.model.User;
import com.techelevator.model.YelpKey;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class YelpKeyTest extends FinalCapstoneDaoTests {

    @Test
    public void can_this_read_the_yelp_file(){
        YelpKey test = new YelpKey();
        String result = test.getKey();
        Assert.assertEquals("2MCP7YJJ-etjT0Mj5aB7skyln1iue4QI-4HuaG5GIt935jt_DfEz3fuoDSdERXDuQWre6R3qUcNDGaTP8olxLBzg4Fh-__QCTQ8zsCAT1xFX84_klZ0_Cc_3x4yqYXYx", result);
    }

}
