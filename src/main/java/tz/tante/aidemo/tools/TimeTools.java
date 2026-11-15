package tz.tante.aidemo.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class TimeTools
{
  private static final Logger logger = LoggerFactory.getLogger(TimeTools.class);

  @McpTool(name = "getCurrentTime", description = "Get the current time in the user's local timezone")
  public String getCurrentTime(@McpToolParam(description = "The timezone to get the current time for") String timezone)
  {
    String now = LocalDateTime.now(ZoneId.of(timezone)).toString();
    logger.info("Current time in a given timezone: {}", now);
    return now;
  }

  @McpTool(name = "getCurrentLocalTime", description = "Get the current time in the user's local timezone")
  public String getCurrentLocalTime()
  {
    String now = LocalDateTime.now().toString();
    logger.info("Current time: {}", now);
    return now;
  }

}
