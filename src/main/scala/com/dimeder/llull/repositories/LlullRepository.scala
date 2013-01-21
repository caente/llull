package com.dimeder.llull.repositories

import org.springframework.data.neo4j.repository.GraphRepository
import com.dimeder.llull.models.Word

/**
 * Created with IntelliJ IDEA.
 * User: caente
 * Date: 15/01/13
 * Time: 03:07 PM
 * To change this template use File | Settings | File Templates.
 */
trait LlullRepository extends GraphRepository[Word]
