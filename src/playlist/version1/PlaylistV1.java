/*******************************************************************************
 *     SDR Trunk 
 *     Copyright (C) 2014 Dennis Sheirer
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package playlist.version1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import alias.Alias;
import controller.channel.Channel;

@XmlSeeAlso( { AliasDirectory.class,
			   Alias.class,
			   Channel.class,
			   ChannelMapList.class,
			   SystemList.class } )

@Deprecated
@XmlRootElement( name = "playlist" )
public class PlaylistV1
{
	//Note: these are for legacy version 1 format playlists
	private AliasDirectory mAliasDirectory = new AliasDirectory();
	private ChannelMapList mChannelMapList = new ChannelMapList();
	private SystemList mSystemList = new SystemList();

	public PlaylistV1()
	{
	}
	
	@XmlElement( name = "alias_directory" )
	public AliasDirectory getAliasDirectory()
	{
		mAliasDirectory.refresh();
		
		return mAliasDirectory;
	}
	
	
	public void setAliasDirectory( AliasDirectory directory )
	{
		mAliasDirectory = directory;
	}

	public boolean hasAliasDirectory()
	{
		return mAliasDirectory != null && 
			   mAliasDirectory.getAliasList() != null && 
			   !mAliasDirectory.getAliasList().isEmpty();
	}

	
	@XmlElement( name = "system_list" )
	public SystemList getSystemList()
	{
		return mSystemList;
	}

	
	public void setSystemList( SystemList list )
	{
		mSystemList = list;
	}
	
	public boolean hasSystemList()
	{
		return mSystemList != null && 
			   mSystemList.getSystem() != null && 
			   !mSystemList.getSystem().isEmpty();
	}
	
	
	@XmlElement( name = "channel_maps" )
	public ChannelMapList getChannelMapList()
	{
		return mChannelMapList;
	}
	
	public boolean hasChannelMapList()
	{
		return mChannelMapList != null &&
			   mChannelMapList.getChannelMap() != null &&
			   !mChannelMapList.getChannelMap().isEmpty();
	}
	
	
	public void setChannelMapList( ChannelMapList list )
	{
		mChannelMapList = list;
	}
}
