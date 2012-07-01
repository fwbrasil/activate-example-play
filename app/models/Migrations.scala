package models

import computerPersistenceContext._
import net.fwbrasil.activate.migration.Migration
import scala.collection.mutable.{ Map => MutableMap }
import java.util.Date

class CreateSchema extends Migration {
	def timestamp = 201206301707l
	def name = "TimedThresholdsMigration"
	def developers = List("fwbrasil")

	def up = {
		removeAllEntitiesTables
			.ifExists
		createTableForAllEntities
			.ifNotExists
	}
}

class SeedData extends Migration {

	def timestamp = 201206301707l
	def name = "Seed data migration"
	def developers = List("fwbrasil")

	def up = {
		customScript {
			val companies = MutableMap[Int, Company]()
			companies += (1 -> new Company("Apple Inc."))
			companies += (2 -> new Company("Thinking Machines"))
			companies += (3 -> new Company("RCA"))
			companies += (4 -> new Company("Netronics"))
			companies += (5 -> new Company("Tandy Corporation"))
			companies += (6 -> new Company("Commodore International"))
			companies += (7 -> new Company("MOS Technology"))
			companies += (8 -> new Company("Micro Instrumentation and Telemetry Systems"))
			companies += (9 -> new Company("IMS Associates, Inc."))
			companies += (10 -> new Company("Digital Equipment Corporation"))
			companies += (11 -> new Company("Lincoln Laboratory"))
			companies += (12 -> new Company("Moore School of Electrical Engineering"))
			companies += (13 -> new Company("IBM"))
			companies += (14 -> new Company("Amiga Corporation"))
			companies += (15 -> new Company("Canon"))
			companies += (16 -> new Company("Nokia"))
			companies += (17 -> new Company("Sony"))
			companies += (18 -> new Company("OQO"))
			companies += (19 -> new Company("NeXT"))
			companies += (20 -> new Company("Atari"))
			companies += (21 -> new Company("Acorn computer"))
			companies += (22 -> new Company("Timex Sinclair"))
			companies += (23 -> new Company("Nintendo"))
			companies += (24 -> new Company("Sinclair Research Ltd"))
			companies += (25 -> new Company("Xerox"))
			companies += (26 -> new Company("Hewlett-Packard"))
			companies += (27 -> new Company("Zemmix"))
			companies += (28 -> new Company("ACVS"))
			companies += (29 -> new Company("Sanyo"))
			companies += (30 -> new Company("Cray"))
			companies += (31 -> new Company("Evans & Sutherland"))
			companies += (32 -> new Company("E.S.R. Inc."))
			companies += (33 -> new Company("OMRON"))
			companies += (34 -> new Company("BBN Technologies"))
			companies += (35 -> new Company("Lenovo Group"))
			companies += (36 -> new Company("ASUS"))
			companies += (37 -> new Company("Amstrad"))
			companies += (38 -> new Company("Sun Microsystems"))
			companies += (39 -> new Company("Texas Instruments"))
			companies += (40 -> new Company("HTC Corporation"))
			companies += (41 -> new Company("Research In Motion"))
			companies += (42 -> new Company("Samsung Electronics"))

				//Yes, I am lazy!
				implicit def intToCompanyOption(i: Int) =
					companies.get(i)
				implicit def stringToDateOption(s: String) =
					Option(new Date())

			new Computer("MacBook Pro 15.4 inch", None, None, 1);
			new Computer("CM-2a", None, None, 2);
			new Computer("CM-200", None, None, 2);
			new Computer("CM-5e", None, None, 2);
			new Computer("CM-5", "1991-01-01", None, 2);
			new Computer("MacBook Pro", "2006-01-10", None, 1);
			new Computer("Apple IIe", None, None, 1);
			new Computer("Apple IIc", None, None, 1);
			new Computer("Apple IIGS", None, None, 1);
			new Computer("Apple IIc Plus", None, None, 1);
			new Computer("Apple II Plus", None, None, 1);
			new Computer("Apple III", "1980-05-01", "1984-04-01", 1);
			new Computer("Apple Lisa", None, None, 1);
			new Computer("CM-2", None, None, 2);
			new Computer("Connection Machine", "1987-01-01", None, 2);
			new Computer("Apple II", "1977-04-01", "1993-10-01", 1);
			new Computer("Apple III Plus", "1983-12-01", "1984-04-01", 1);
			new Computer("COSMAC ELF", None, None, 3);
			new Computer("COSMAC VIP", "1977-01-01", None, 3);
			new Computer("ELF II", "1977-01-01", None, 4);
			new Computer("Macintosh", "1984-01-24", None, 1);
			new Computer("Macintosh II", None, None, None);
			new Computer("Macintosh Plus", "1986-01-16", "1990-10-15", 1);
			new Computer("Macintosh IIfx", None, None, None);
			new Computer("iMac", "1998-01-01", None, 1);
			new Computer("Mac Mini", "2005-01-22", None, 1);
			new Computer("Mac Pro", "2006-08-07", None, 1);
			new Computer("Power Macintosh", "1994-03-01", "2006-08-01", 1);
			new Computer("PowerBook", "1991-01-01", "2006-01-01", 1);
			new Computer("Xserve", None, None, None);
			new Computer("Powerbook 100", None, None, None);
			new Computer("Powerbook 140", None, None, None);
			new Computer("Powerbook 170", None, None, None);
			new Computer("PowerBook Duo", None, None, None);
			new Computer("PowerBook 190", None, None, None);
			new Computer("Macintosh Quadra", "1991-01-01", None, 1);
			new Computer("Macintosh Quadra 900", None, None, None);
			new Computer("Macintosh Quadra 700", None, None, None);
			new Computer("Macintosh LC", "1990-01-01", None, 1);
			new Computer("Macintosh LC II", "1990-01-01", None, 1);
			new Computer("Macintosh LC III", "1993-01-01", None, 1);
			new Computer("Macintosh LC III+", None, None, None);
			new Computer("Macintosh Quadra 605", "1993-10-21", None, 1);
			new Computer("Macintosh LC 500 series", None, None, None);
			new Computer("TRS-80 Color Computer", "1980-01-01", None, 5);
			new Computer("Acorn System 2", None, None, None);
			new Computer("Dragon 32/64", None, None, None);
			new Computer("MEK6800D2", None, None, None);
			new Computer("Newbear 77/68", None, None, None);
			new Computer("Commodore PET", None, None, 6);
			new Computer("Commodore 64", "1982-08-01", "1994-01-01", 6);
			new Computer("Commodore 64C", None, None, None);
			new Computer("Commodore SX-64", None, None, 6);
			new Computer("Commodore 128", None, None, 6);
			new Computer("Apple I", "1976-04-01", "1977-10-01", 1);
			new Computer("KIM-1", "1975-01-01", None, 7);
			new Computer("Altair 8800", "1974-12-19", None, 8);
			new Computer("IMSAI 8080", "1975-08-01", None, 9);
			new Computer("IMSAI Series Two", None, None, None);
			new Computer("VAX", "1977-10-25", None, 10);
			new Computer("VAX 11/780", "1977-10-25", None, 10);
			new Computer("VAX 11/750", "1980-10-01", None, 10);
			new Computer("TX-2", "1958-01-01", None, 11);
			new Computer("TX-0", "1956-01-01", None, 11);
			new Computer("Whirlwind", "1951-04-20", None, 11);
			new Computer("ENIAC", "1946-02-15", "1955-10-02", 12);
			new Computer("IBM PC", "1981-08-12", None, 13);
			new Computer("Macintosh Classic", None, None, None);
			new Computer("Macintosh Classic II", "1991-01-01", None, 1);
			new Computer("Amiga", "1985-01-01", None, 14);
			new Computer("Amiga 1000", None, None, 6);
			new Computer("Amiga 500", "1987-01-01", None, 6);
			new Computer("Amiga 500+", None, None, None);
			new Computer("Amiga 2000", "1986-01-01", "1990-01-01", 6);
			new Computer("Amiga 3000", None, None, 6);
			new Computer("Amiga 600", "1992-03-01", None, 6);
			new Computer("Macintosh 128K", "1984-01-01", None, 1);
			new Computer("Macintosh 512K", "1984-09-10", "1986-04-14", 1);
			new Computer("Macintosh SE", "1987-03-02", "1989-08-01", 1);
			new Computer("Macintosh SE/30", "1989-01-19", "1991-10-21", 1);
			new Computer("Canon Cat", "1987-01-01", None, 15);
			new Computer("Nokia 770", None, None, 16);
			new Computer("Nokia N800", "2007-01-01", None, 16);
			new Computer("Mylo", "2006-09-21", None, 17);
			new Computer("OQO 02", "2007-01-01", None, 18);
			new Computer("OQO 01+", None, None, None);
			new Computer("Pinwheel calculator", None, None, None);
			new Computer("iBook", None, None, 1);
			new Computer("MacBook", "2006-05-16", None, 1);
			new Computer("NeXTstation", "1990-01-01", "1993-01-01", 19);
			new Computer("NeXTcube", "1988-01-01", "1993-01-01", 19);
			new Computer("NeXTstation Color Turbo", None, None, None);
			new Computer("NeXTstation Color", None, None, None);
			new Computer("NeXTstation Turbo", None, None, None);
			new Computer("NeXTcube Turbo", None, None, 19);
			new Computer("NeXTcube 040", None, None, 19);
			new Computer("NeXTcube 030", None, None, 19);
			new Computer("Tinkertoy Tic-Tac-Toe Computer", None, None, None);
			new Computer("Z3", None, None, None);
			new Computer("Z4", None, None, None);
			new Computer("Z1", None, None, None);
			new Computer("Z2", None, None, None);
			new Computer("Wang 2200", "1973-05-01", None, None);
			new Computer("Wang VS", None, None, None);
			new Computer("Wang OIS", None, None, None);
			new Computer("BBC Micro", None, None, 22);
			new Computer("IBM 650", "1953-01-01", "1962-01-01", 13);
			new Computer("Cray-1", None, None, None);
			new Computer("Cray-3", None, None, None);
			new Computer("Cray-2", None, None, None);
			new Computer("Cray-4", None, None, None);
			new Computer("Cray X1", None, None, None);
			new Computer("Cray XD1", None, None, None);
			new Computer("Cray T3D", "1993-01-01", None, None);
			new Computer("Cray T3E", "1995-01-01", None, None);
			new Computer("Cray C90", None, None, None);
			new Computer("Cray T90", None, None, None);
			new Computer("Cray SV1", None, None, None);
			new Computer("Cray J90", None, None, None);
			new Computer("Cray XT3", None, None, None);
			new Computer("Cray CS6400", None, None, None);
			new Computer("Atari ST", "1985-01-01", "1993-01-01", 20);
			new Computer("Amiga 2500", None, None, None);
			new Computer("Amiga 2500", None, None, 6);
			new Computer("Amiga 4000", None, None, 6);
			new Computer("Amiga 3000UX", None, None, 6);
			new Computer("Amiga 3000T", None, None, 6);
			new Computer("Amiga 4000T", None, None, 6);
			new Computer("Amiga 1200", "1992-10-01", "1996-01-01", 6);
			new Computer("Atari 1040 STf", "1986-01-01", None, None);
			new Computer("Atari 520 ST", "1985-01-01", None, None);
			new Computer("Atari 520 STfm", "1986-01-01", None, None);
			new Computer("Atari 1040 STe", "1989-01-01", None, None);
			new Computer("Atari MEGA STe", "1991-01-01", None, None);
			new Computer("Atari 520 ST+", "1985-01-01", None, None);
			new Computer("Atari 520 STm", "1985-01-01", None, None);
			new Computer("Atari 130 ST", "1985-01-01", None, None);
			new Computer("Atari 260 ST", "1985-01-01", None, None);
			new Computer("Atari MEGA ST", "1987-01-01", None, None);
			new Computer("Atari 520 STf", "1986-01-01", None, None);
			new Computer("Atari 1040 STfm", "1986-01-01", None, None);
			new Computer("Atari 2080 ST", "1986-01-01", None, None);
			new Computer("Atari 260 ST+", "1985-01-01", None, None);
			new Computer("Atari 4160 STe", "1988-01-01", None, None);
			new Computer("TRS-80 Color Computer 2", None, None, None);
			new Computer("TRS-80 Color Computer 3", None, None, None);
			new Computer("TRS-80 Model 1", "1977-01-01", None, 5);
			new Computer("Timex Sinclair 2068", "1983-11-01", "1984-04-01", 23);
			new Computer("ZX Spectrum", "1982-01-01", None, 25);
			new Computer("Xerox Star", "1981-01-01", None, 26);
			new Computer("Xerox Alto", None, None, None);
			new Computer("Acorn Archimedes", None, None, 22);
			new Computer("Nintendo Entertainment System", None, None, 24);
			new Computer("Super Nintendo Entertainment System", "1991-08-01", "1999-01-01", 24)
			new Computer("Super Famicom", None, None, None);
			new Computer("Nintendo GameCube", None, None, 24);
			new Computer("Game Boy line", None, None, None);
			new Computer("PlayStation", "1994-12-03", None, 17);
			new Computer("PlayStation 2", "2000-03-24", None, 17);
			new Computer("Game & Watch", None, None, 24);
			new Computer("EDSAC", None, None, None);
			new Computer("IBM System/4 Pi", None, None, None);
			new Computer("IBM AP-101", None, None, None);
			new Computer("IBM TC-1", None, None, None);
			new Computer("IBM AP-101B", None, None, None);
			new Computer("IBM AP-101S", None, None, 13);
			new Computer("ProLiant", None, None, 27);
			new Computer("Sinclair QL", "1984-01-01", "1986-01-01", 25);
			new Computer("Sinclair ZX81", "1981-01-01", None, 25);
			new Computer("Sinclair ZX80", None, None, 25);
			new Computer("Atari 65XE", None, None, 20);
			new Computer("Deep Blue", None, None, None);
			new Computer("Macintosh Quadra 650", None, None, None);
			new Computer("Macintosh Quadra 610", None, None, None);
			new Computer("Macintosh Quadra 800", None, None, None);
			new Computer("Macintosh Quadra 950", None, None, None);
			new Computer("PowerBook 160", None, None, None);
			new Computer("PowerBook 145B", None, None, None);
			new Computer("PowerBook 170", None, None, None);
			new Computer("PowerBook 145", None, None, None);
			new Computer("PowerBook G3", None, None, None);
			new Computer("PowerBook 140", None, None, None);
			new Computer("Macintosh IIcx", None, None, None);
			new Computer("Powerbook 180", None, None, None);
			new Computer("PowerBook G4", None, None, None);
			new Computer("Macintosh XL", None, None, None);
			new Computer("PowerBook 100", None, None, None);
			new Computer("PowerBook 2400c", None, None, None);
			new Computer("PowerBook 1400", None, None, None);
			new Computer("Macintosh Quadra 630", None, None, None);
			new Computer("Macintosh Quadra 660AV", None, None, None);
			new Computer("Macintosh Quadra 840AV", None, None, None);
			new Computer("PowerBook 5300", None, None, None);
			new Computer("PowerBook 3400c", None, None, None);
			new Computer("Macintosh Color Classic", None, None, None);
			new Computer("Macintosh 512Ke", None, None, None);
			new Computer("Macintosh IIsi", None, None, None);
			new Computer("Macintosh IIx", None, None, None);
			new Computer("PowerBook 500 series", None, None, None);
			new Computer("Power Macintosh G3", None, None, None);
			new Computer("Macintosh IIci", None, None, None);
			new Computer("iMac G5", "2004-08-31", None, 1);
			new Computer("Power Mac G4", None, None, None);
			new Computer("Power Macintosh 7100", None, None, None);
			new Computer("Power Macintosh 9600", None, None, None);
			new Computer("Power Macintosh 7200", None, None, None);
			new Computer("Power Macintosh 7300", None, None, None);
			new Computer("Power Macintosh 8600", None, None, None);
			new Computer("Power Macintosh 6200", None, None, None);
			new Computer("Power Macintosh 8100", None, None, None);
			new Computer("Compact Macintosh", None, None, None);
			new Computer("Power Macintosh 4400", None, None, None);
			new Computer("Power Macintosh 9500", None, None, None);
			new Computer("Macintosh Portable", None, None, None);
			new Computer("EMac", None, None, None);
			new Computer("Power Macintosh 7600", None, None, None);
			new Computer("Power Mac G5", None, None, None);
			new Computer("Power Macintosh 7500", None, None, None);
			new Computer("Power Macintosh 6100", None, None, None);
			new Computer("Power Macintosh 8500", None, None, None);
			new Computer("Macintosh IIvi", None, None, None);
			new Computer("Macintosh IIvx", None, None, None);
			new Computer("IMac G3", None, None, None);
			new Computer("IMac G4", None, None, None);
			new Computer("Power Mac G4 Cube", None, None, 1);
			new Computer("Intel iMac", None, None, None);
			new Computer("Deep Thought", None, None, 13);
			new Computer("Wii", "2006-11-19", None, 24);
			new Computer("IBM System x", None, None, None);
			new Computer("IBM System i", "2006-01-01", None, 13);
			new Computer("IBM System z", "2006-01-01", None, 13);
			new Computer("IBM System p", "2000-01-01", None, 13);
			new Computer("LC 575", None, None, None);
			new Computer("Macintosh TV", None, None, None);
			new Computer("Macintosh Performa", None, None, None);
			new Computer("Macintosh II series", None, None, None);
			new Computer("Power Macintosh 6400", None, None, None);
			new Computer("Power Macintosh 6500", None, None, None);
			new Computer("Apple PenLite", None, None, None);
			new Computer("Wallstreet", None, None, None);
			new Computer("Twentieth Anniversary Macintosh", None, None, None);
			new Computer("Power Macintosh 5500", None, None, None);
			new Computer("iBook G3", None, None, 1);
			new Computer("Power Macintosh 5200 LC", None, None, None);
			new Computer("Power Macintosh 5400", None, None, None);
			new Computer("CM-1", None, None, None);
			new Computer("MSX", "1983-01-01", "1995-01-01", 28);
			new Computer("PlayStation 3", None, None, 17);
			new Computer("MSX2", "1986-01-01", None, 29);
			new Computer("MSX2+", "1988-01-01", None, 30);
			new Computer("MSX turbo R", "1990-01-01", None, None);
			new Computer("Panasonic FS A1GT", None, None, None);
			new Computer("Panasonic FS A1ST", None, None, None);
			new Computer("PDP-11", None, None, 10);
			new Computer("PDP-1", None, None, 10);
			new Computer("PDP-10", None, None, 10);
			new Computer("PDP-8", None, None, 10);
			new Computer("PDP-6", None, None, 10);
			new Computer("DECSYSTEM-20", None, None, 10);
			new Computer("PDP-7", None, None, 10);
			new Computer("PDP-5", None, None, 10);
			new Computer("PDP-12", None, None, 10);
			new Computer("LINC", None, None, 10);
			new Computer("PDP-14", None, None, 10);
			new Computer("PDP-15", None, None, 10);
			new Computer("PDP-16", None, None, 10);
			new Computer("Cray X2", "2007-01-01", None, 31);
			new Computer("Cray X-MP", "1982-01-01", None, 31);
			new Computer("Evans & Sutherland ES-1", None, None, 32);
			new Computer("Commodore VIC-20", "1980-01-01", None, 6);
			new Computer("PowerBook 150", None, None, None);
			new Computer("MacBook Air", "2008-01-15", None, 1);
			new Computer("Digi-Comp I", "1963-01-01", None, 33);
			new Computer("Digi-Comp", None, None, None);
			new Computer("Digi-Comp II", None, None, 33);
			new Computer("Manchester Mark I", "1949-01-01", None, None);
			new Computer("Nintendo 64", None, None, 24);
			new Computer("Game Boy Advance", None, None, 24);
			new Computer("Game Boy", None, None, 24);
			new Computer("Nintendo DS Lite", None, None, 24);
			new Computer("Nintendo DS", "2004-01-01", None, 24);
			new Computer("Game Boy Color", None, None, 24);
			new Computer("Game Boy Advance SP", None, None, 24);
			new Computer("Virtual Boy", None, None, 24);
			new Computer("Game Boy Micro", None, None, 24);
			new Computer("Roadrunner", None, None, 13);
			new Computer("HP 9000", None, None, None);
			new Computer("OMRON Luna-88K2", None, None, None);
			new Computer("OMRON Luna-88K", None, None, 34);
			new Computer("Motorola series 900", None, None, None);
			new Computer("Motorola M8120", None, None, None);
			new Computer("Triton Dolphin System 100", None, None, None);
			new Computer("BBN TC2000", "1989-08-01", None, 35);
			new Computer("WRT54G", None, None, None);
			new Computer("ThinkPad", "1992-01-01", None, 36);
			new Computer("Apple Newton", "1993-01-01", "1998-01-01", 1);
			new Computer("Atanasoff-Berry Computer", "1937-01-01", None, None);
			new Computer("Atlas Computer", "1962-01-01", "1974-01-01", None);
			new Computer("ASUS Eee PC 901", None, None, 37);
			new Computer("ASUS Eee PC 701", None, None, None);
			new Computer("IBM 7030", "1961-01-01", None, 13);
			new Computer("System/38", "1979-01-01", None, 13);
			new Computer("System/36", "1983-01-01", "2000-01-01", 13);
			new Computer("IBM 7090", "1959-01-01", None, 13);
			new Computer("IBM RT", None, None, 13);
			new Computer("System/360", "1964-01-01", None, 13);
			new Computer("IBM 801", "1980-01-01", None, 13);
			new Computer("IBM 1401", "1959-01-01", None, 13);
			new Computer("ASCI White", "2001-01-01", "2006-01-01", 13);
			new Computer("Blue Gene", None, None, 13);
			new Computer("ASCI Blue Pacific", "1998-01-01", None, 13);
			new Computer("iPhone", "2007-06-01", None, 1);
			new Computer("Nokia N810", "2007-10-17", None, 16);
			new Computer("EDSAC 2", None, None, None);
			new Computer("Titan", None, None, None);
			new Computer("Pilot ACE", None, None, None);
			new Computer("HP Mini 1000", "2008-10-29", None, 27);
			new Computer("HP 2133 Mini-Note PC", "2008-04-15", None, 27);
			new Computer("Kogan Agora Pro", "2008-12-04", None, None);
			new Computer("D-Series Machines", None, None, None);
			new Computer("ZX Spectrum 48K", "1982-01-01", None, 25);
			new Computer("ZX Spectrum 16K", "1982-01-01", None, 25);
			new Computer("ZX Spectrum 128", "1985-09-01", None, 25);
			new Computer("ZX Spectrum +3", None, None, 38);
			new Computer("ZX Spectrum +2", "1986-01-01", None, 38);
			new Computer("ZX Spectrum +2A", "1987-01-01", None, 38);
			new Computer("ZX Spectrum +", "1984-06-01", None, 25);
			new Computer("Acer Extensa", None, None, None);
			new Computer("Acer Extensa 5220", None, None, None);
			new Computer("Dell Latitude", None, None, None);
			new Computer("Toshiba Satellite", None, None, None);
			new Computer("Timex Sinclair 2048", None, None, 23);
			new Computer("Sprinter", None, None, None);
			new Computer("Timex Computer 2048", None, None, None);
			new Computer("Pentagon", None, None, None);
			new Computer("Belle", None, None, None);
			new Computer("Loki", None, None, 25);
			new Computer("Hobbit", None, None, None);
			new Computer("NeXT Computer", None, None, 19);
			new Computer("TRS-80", None, None, None);
			new Computer("TRS-80 Model 2", "1980-01-01", None, 5);
			new Computer("TRS-80 Model 3", None, None, 5);
			new Computer("STacy", "1989-01-01", None, None);
			new Computer("ST BOOK", "1990-01-01", None, None);
			new Computer("Atari 520 STE", "1989-01-01", None, None);
			new Computer("Amiga 2000 Model A", None, None, None);
			new Computer("Amiga 2000 Model B", None, None, None);
			new Computer("Amiga 2000 Model C", None, None, None);
			new Computer("IBM 3270", None, None, None);
			new Computer("CALDIC", None, None, None);
			new Computer("Modbook", None, None, None);
			new Computer("Compaq SystemPro", None, None, None);
			new Computer("ARRA", None, None, None);
			new Computer("IBM System Cluster 1350", None, None, None);
			new Computer("Finite element machine", None, None, None);
			new Computer("ES7000", None, None, None);
			new Computer("HP MediaSmart Server", None, None, None);
			new Computer("HP Superdome", None, None, None);
			new Computer("IBM Power Systems", "2008-01-01", None, 13);
			new Computer("Oslo Analyzer", None, None, None);
			new Computer("Microsoft Softcard", None, None, None);
			new Computer("WITCH", None, None, None);
			new Computer("Analytical engine", None, None, None);
			new Computer("EDVAC", None, None, None);
			new Computer("BINAC", None, None, None);
			new Computer("Earth Simulator", None, None, None);
			new Computer("BARK", None, None, None);
			new Computer("Harvard Mark I", "1944-01-01", None, 13);
			new Computer("ILLIAC IV", None, None, None);
			new Computer("ILLIAC II", None, None, None);
			new Computer("ILLIAC III", None, None, None);
			new Computer("Water integrator", None, None, None);
			new Computer("CSIRAC", None, None, None);
			new Computer("System X", None, None, None);
			new Computer("Harvest", None, None, None);
			new Computer("ChipTest", None, None, None);
			new Computer("HiTech", None, None, None);
			new Computer("Bomba", None, None, None);
			new Computer("ACE", None, None, None);
			new Computer("ASCI Red", None, None, None);
			new Computer("ASCI Thors Hammer", None, None, None);
			new Computer("ASCI Purple", "2005-01-01", None, 13);
			new Computer("ASCI Blue Mountain", None, None, None);
			new Computer("Columbia", None, None, None);
			new Computer("HP Integrity", None, None, None);
			new Computer("APEXC", None, None, None);
			new Computer("Datasaab D2", None, None, None);
			new Computer("BRLESC", None, None, None);
			new Computer("DYSEAC", None, None, None);
			new Computer("SSEC", "1948-01-01", None, 13);
			new Computer("Hydra", None, None, None);
			new Computer("FUJIC", None, None, None);
			new Computer("RAYDAC", None, None, None);
			new Computer("Harvard Mark III", None, None, None);
			new Computer("DATAR", None, None, None);
			new Computer("ReserVec", None, None, None);
			new Computer("DASK", None, None, None);
			new Computer("UTEC", None, None, None);
			new Computer("DRTE Computer", None, None, None);
			new Computer("PowerEdge", None, None, None);
			new Computer("Apple Network Server", None, None, None);
			new Computer("Goodyear MPP", None, None, None);
			new Computer("Macintosh 128K technical details", None, None, None);
			new Computer("Power Macintosh G3", None, None, None);
			new Computer("CER-10", None, None, None);
			new Computer("CER-20", None, None, None);
			new Computer("IBM BladeCenter", "2002-01-01", None, 13);
			new Computer("Amstrad CPC", None, None, 38);
			new Computer("Amstrad CPC 6128", None, None, 38);
			new Computer("Amstrad CPC 664", None, None, 38);
			new Computer("Amstrad CPC 464", None, None, 38);
			new Computer("Intergraph", None, None, None);
			new Computer("Enterprise", None, None, None);
			new Computer("MTX500", None, None, None);
			new Computer("Acorn Electron", None, None, None);
			new Computer("Sony Vaio P", "2009-02-01", None, 17);
			new Computer("VAIO", None, None, 17);
			new Computer("Sony Vaio P VGN-P588E/Q", None, None, None);
			new Computer("Sony Vaio P VGN-P530H/G", None, None, None);
			new Computer("Sony Vaio P VGN-P530H/W", None, None, None);
			new Computer("Sony Vaio P VGN-P530H/Q", None, None, None);
			new Computer("Sony Vaio P VGN-P530H/R", None, None, None);
			new Computer("Sony Vaio P VGN-P588E/R", None, None, None);
			new Computer("Sony Vaio P VGN-P598E/Q", None, None, None);
			new Computer("Timex Sinclair 1000", "1982-07-01", None, 23);
			new Computer("Komputer 2086", None, None, None);
			new Computer("Galaksija", None, None, None);
			new Computer("Vector-06C", None, None, None);
			new Computer("Elektronika BK", None, None, None);
			new Computer("Sun386i", None, None, 39);
			new Computer("Xerox Daybreak", "1985-01-01", "1989-01-01", None);
			new Computer("Xerox NoteTaker", None, None, 26);
			new Computer("D4a", "1965-01-01", None, None);
			new Computer("LGP-30", None, None, None);
			new Computer("LGP-21", None, None, None);
			new Computer("ASUS Eee PC 900", "2008-05-01", None, 37);
			new Computer("Atari TT030", None, None, None);
			new Computer("Bi Am ZX-Spectrum 48/64", None, None, None);
			new Computer("Bi Am ZX-Spectrum 128", None, None, None);
			new Computer("PlayStation Portable", None, None, None);
			new Computer("MSI Wind Netbook", None, None, None);
			new Computer("Sharp Mebius NJ70A", "2009-04-21", None, None);
			new Computer("HTC Snap", None, None, 41);
			new Computer("Commodore Educator 64", None, None, 6);
			new Computer("Amiga 1500", None, None, 6);
			new Computer("Commodore 65", None, None, 6);
			new Computer("Commodore 16", None, None, 6);
			new Computer("Commodore CBM-II", None, None, 6);
			new Computer("Commodore Plus/4", None, None, 6);
			new Computer("Commodore LCD", None, None, 6);
			new Computer("Commodore MAX Machine", None, None, 6);
			new Computer("Aster CT-80", None, None, None);
			new Computer("Test", "2009-01-01", "2009-01-01", None);
			new Computer("MSI GX723", None, None, None);
			new Computer("Eee PC 1000HV", "2009-05-22", None, None);
			new Computer("VTech Laser 200", "1983-01-01", None, None);
			new Computer("CrunchPad", None, None, None);
			new Computer("Neo Geo", "1990-01-01", None, None);
			new Computer("Sega Mega Drive", None, None, None);
			new Computer("Sega Master System", None, None, None);
			new Computer("TurboGrafx-16", None, None, None);
			new Computer("Sun-3", None, None, 39);
			new Computer("Pleiades", None, None, None);
			new Computer("IBM Sequoia", None, None, None);
			new Computer("Inves Spectrum 48k plus", None, None, None);
			new Computer("iPhone 3G", None, None, None);
			new Computer("iPhone 3GS", None, None, None);
			new Computer("Beagle Board", None, None, 40);
			new Computer("HP nPar", None, None, None);
			new Computer("MacBook Family", None, None, None);
			new Computer("Reservisor", None, None, None);
			new Computer("BladeSystem", None, None, None);
			new Computer("lenovo thinkpad t60p", None, None, None);
			new Computer("lenovo thinkpad x200", None, None, 36);
			new Computer("lenovo thinkpad t60", None, None, None);
			new Computer("lenovo thinkpad w700", None, None, None);
			new Computer("lenovo thinkpad t41", None, None, None);
			new Computer("lenovo thinkpad z61p", None, None, None);
			new Computer("lenovo thinkpad x61s", None, None, None);
			new Computer("lenovo thinkpad t43", None, None, None);
			new Computer("lenovo thinkpad r400", None, None, None);
			new Computer("lenovo thinkpad x60s", None, None, None);
			new Computer("lenovo thinkpad x301", None, None, None);
			new Computer("lenovo thinkpad t42", None, None, None);
			new Computer("lenovo thinkpad r61", None, None, None);
			new Computer("lenovo thinkpad w500", None, None, None);
			new Computer("lenovo thinkpad sl400", None, None, None);
			new Computer("lenovo thinkpad x40", None, None, None);
			new Computer("lenovo thinkpad x200 tablet", None, None, 36);
			new Computer("lenovo thinkpad t400s", None, None, None);
			new Computer("Nokia N900", "2009-10-01", None, 16);
			new Computer("Internet Tablet", None, None, None);
			new Computer("CS-2", None, None, None);
			new Computer("IBM 701", "1952-01-01", None, 13);
			new Computer("IBM 5100", "1975-01-01", None, 13);
			new Computer("AN/FSQ-7", "1958-01-01", None, 13);
			new Computer("AN/FSQ-32", "1960-01-01", None, 13);
			new Computer("IBM CPC", "1949-01-01", None, 13);
			new Computer("System/34", "1978-01-01", "1983-01-01", 13);
			new Computer("System/32", "1975-01-01", None, 13);
			new Computer("System/3", "1969-01-01", "1985-01-01", 13);
			new Computer("IBM 305", "1956-01-01", None, 13);
			new Computer("English Electric DEUCE", None, None, None);
			new Computer("CER-203", None, None, None);
			new Computer("CER-22", None, None, None);
			new Computer("Kentucky Linux Athlon Testbed", None, None, None);
			new Computer("QNAP TS-101", None, None, None);
			new Computer("iPad", "2010-01-01", "2011-03-02", 1);
			new Computer("iPhone 2G", None, None, None);
			new Computer("Inslaw", None, None, None);
			new Computer("WePad", "2010-07-01", None, None);
			new Computer("MacBook Parts", None, None, 1);
			new Computer("MC240LL/A", None, None, None);
			new Computer("D.K.COMMUNICATION", None, None, None);
			new Computer("iPhone 4", None, None, 1);
			new Computer("Nintendo 3DS", "2010-03-23", None, 24);
			new Computer("ASUS Eee PC 1005PE", "2010-01-01", None, 37);
			new Computer("National Law Enforcement System", None, None, None);
			new Computer("BlackBerry PlayBook", None, None, 42);
			new Computer("Barnes & Noble nook", "2009-10-20", None, None);
			new Computer("SAM Coupé", None, None, None);
			new Computer("HTC Dream", "2008-10-22", None, 41);
			new Computer("Samsung Galaxy Tab", "2010-09-02", None, 43);
			new Computer("BlackBerry PlayBook", "2010-09-27", None, 42);
			new Computer("Tianhe-I", None, None, None);
			new Computer("Kno", None, None, None);
			new Computer("ThinkPad 701 C", None, None, None);
			new Computer("ThinkPad 340 CSE", None, None, None);
			new Computer("ThinkPad 755 CX", None, None, None);
			new Computer("ThinkPad 755 CE", None, None, None);
			new Computer("ThinkPad 370 C", None, None, None);
			new Computer("Coleco Adam", "1983-01-01", None, None);
			new Computer("Nebulae", None, None, None);
			new Computer("Alex eReader", None, None, None);
			new Computer("Acer Iconia", None, None, None);
			new Computer("Archos 101", None, None, None);
			new Computer("Fujitsu Lifebook T900", None, None, None);
			new Computer("Motorola Xoom", None, None, None);
			new Computer("ViewSonic G Tablet", None, None, None);
			new Computer("DEC Professional", "1982-01-01", None, 10);
			new Computer("DEC Multia", "1994-11-07", None, 10);
			new Computer("DEC Firefly", None, None, 10);
			new Computer("DEC 3000 AXP", None, None, 10);
			new Computer("DEC 2000 AXP", "1993-05-25", None, 10);
			new Computer("DEC 4000 AXP", "1992-11-10", None, 10);
			new Computer("DEC 7000/10000 AXP", "1992-11-10", None, 10);
			new Computer("DEC Professional 350", None, None, None);
			new Computer("DEC Rainbow 100", None, None, None);
			new Computer("DEC Professional 325", None, None, None);
			new Computer("DECmate II", None, None, 10);
			new Computer("DECmate", None, None, 10);
			new Computer("DECsystem", None, None, 10);
			new Computer("NetApp Filer", None, None, None);
			new Computer("DEC GT40", None, None, 10);
			new Computer("ecoATM", None, None, None);
			new Computer("MindWave BrainCubed Education Bundle", None, None, None);
			new Computer("PalmPilot", None, None, None);
			new Computer("Upcoming iPhone 5", None, None, 1);
			new Computer("Dell Inspiron 560 Desktop Computer ", None, None, None);
			new Computer("IPad 2", None, None, 1);
			new Computer("HP TouchPad", "2011-02-09", None, 27);
			new Computer("HP Veer", "2011-02-09", None, 27);
			new Computer("Lenovo Thinkpad Edge 11", None, None, 36);
			new Computer("Dell Vostro", None, None, None);
			new Computer("Gateway LT3103U", "2008-01-01", None, None);
			new Computer("iPhone 4S", "2011-10-14", None, 1);

		}
	}
}