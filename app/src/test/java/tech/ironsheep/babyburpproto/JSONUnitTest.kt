package tech.ironsheep.babyburpproto

import org.junit.Test

import tech.ironsheep.babyburpproto.models.Child

import org.junit.Assert.*
import tech.ironsheep.babyburpproto.models.Data

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class JSONUnitTest {
    @Test
    @Throws(Exception::class)
    fun readChildFromJSON() {

        val json = """ {
            "name":"Mitica",
            "sex":"M",
            "birthDate":"2000-12-12",
            "treatments":[
                {
                    "name":"pulica",
                    "startDate":"2000-12-12",
                    "span":5,
                    "drugs":[
                        {
                            "name":"vigantol",
                            "span":4,
                            "dose":"2000-12-12",
                            "icon":"aia_default",
                            "type":"x ore|before meal|after meal|during meal",

                            "morning":true,
                            "noon":false,
                            "evening":true,

                            "startingHour":0,
                            "interval":0
                        },
                        {
                            "name":"vigantol",
                            "span":4,
                            "dose":"12/12/2000",
                            "icon":"aia_default",
                            "type":"x ore|before meal|after meal|during meal",

                            "morning":true,
                            "noon":false,
                            "evening":true,

                            "startingHour":0,
                            "interval":0
                        }
                    ]
                }
            ]
}
                """

        val child = Child.createFromJSON(json)
        assertEquals(child.name, "Mitica")
    }

    @Test
    @Throws(Exception::class)
    fun readChildrenFromJSON() {

        val json: String = ""
        var data:Data = Data.createFromJSON(json)
        print(data.toJSON())
    }
}